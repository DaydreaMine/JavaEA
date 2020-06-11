package club.banyuan.mall.controller;

import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.mapper.UmsAdminMapper;
import club.banyuan.mall.dao.param.AdminQueryParam;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminListResponse;
import club.banyuan.mall.dto.UmsAdminLoginParam;
import club.banyuan.mall.dto.UmsAdminUpdatePasswordParam;
import club.banyuan.mall.exception.CommonException;
import club.banyuan.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "AdminController", description = "管理员接口")
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminService adminService;


    @ApiOperation(value = "登录(返回 token)", notes = "登录接口备注")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


    @ApiOperation(value = "创建用户")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult create(@RequestBody UmsAdminCreateParam param) {
//        try {
        adminService.createUser(param);
        return CommonResult.success("OK");
//        } catch (CommonException e){
//          return CommonResult.failed();
//        }

    }

    //分页
    @GetMapping(value = "/list")
    @ApiOperation(value = "用户列表")
    public CommonResult list(@ApiParam(name = "keword",value = "关键词")@RequestParam(value = "keyword",required = false) String keyword,
                             @ApiParam(name = "pageSize",value = "每页数量")@RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize,
                             @ApiParam(name = "pageNum",value = "页数")@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
//        LOGGER.info("keyword is"+keyword);
//        LOGGER.info("pageSize is"+pageSize);
//        LOGGER.info("pageNum is"+pageNum);
        AdminQueryParam adminQueryParam = new AdminQueryParam();
        if (!StringUtils.isEmpty(keyword)){
            adminQueryParam.setKeyword('%'+keyword+'%');
        }
        adminQueryParam.setPageNum(pageNum);
        adminQueryParam.setPageSize(pageSize);
        UmsAdminListResponse response = adminService.list(adminQueryParam);
        return CommonResult.success("ok");
    }

    @GetMapping(value = "/updatePassword")
    @ApiOperation(value = "修改密码")
    public CommonResult updatePassword(@RequestBody UmsAdminUpdatePasswordParam Param) throws CommonException {
        adminService.updatePassword(Param);
        return CommonResult.success("ok");
    }
}
