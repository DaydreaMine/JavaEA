package club.banyuan.mall.controller;

import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.mapper.UmsAdminMapper;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    //    @ApiOperation(value = "登陆（返回TOKEN）", notes = "登陆接口备注")
//    @ResponseBody
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public CommonResult login(){
//
//    }
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
    @GetMapping(value = "/list")
    @ApiOperation(value = "用户列表")
    public CommonResult list(@ApiParam(name = "keword",value = "关键词")@RequestParam(value = "keyword",required = false) String keyword,
                             @ApiParam(name = "pageSize",value = "每页数量")@RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize,
                             @ApiParam(name = "pageNum",value = "页数")@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        LOGGER.info("keyword is"+keyword);
        LOGGER.info("pageSize is"+pageSize);
        LOGGER.info("pageNum is"+pageNum);
        return CommonResult.success("ok");
    }


}
