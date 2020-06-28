package club.banyuan.sr.controller.api;

import club.banyuan.sr.common.api.CommonResult;
import club.banyuan.sr.dao.UserFuckDao;
import club.banyuan.sr.bo.BookHours;
import club.banyuan.sr.dto.UserLoginParam;
import club.banyuan.sr.dto.UserRegisterParam;
import club.banyuan.sr.mapper.UserMapper;
import club.banyuan.sr.model.User;
import club.banyuan.sr.service.SeatService;
import club.banyuan.sr.service.UserService;
import cn.hutool.crypto.digest.BCrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "UserController", description = "用户接口")
@RequestMapping(value = "/api/user")
@RestController
public class UserController {
    @Autowired
    UserFuckDao userFuckDao;

    @Autowired
    UserService userService;

    @Autowired
    SeatService seatService;

    @Autowired
    UserMapper userMapper;

    @ApiOperation(value = "登陆", notes = "登陆接口")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UserLoginParam param, HttpServletRequest request) {
        List<User> tempUser = userService.getExample(param.getUsername());
        if (tempUser.size() == 0) {
            return CommonResult.failed("没有此用户");
        }
        User user = tempUser.get(0);
        try {
            if (!BCrypt.checkpw(param.getPassword(), user.getPassword())) {
                return CommonResult.failed("密码错误！[99982]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("密码错误！[99983]");
        }

        String role = (user.getRole().equals("admin"))?"admin":"user";
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities
        );
        PreAuthenticatedAuthenticationToken authenticationToken = new PreAuthenticatedAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities()
        );

        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        //存入authenticationToken进context(即用authenticationToken替代session)
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return CommonResult.success("登录成功");
    }

    @ApiOperation(value = "登出", notes = "登出接口")
    @GetMapping(value = "/logout")
    public CommonResult logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return CommonResult.success("退出成功");
    }

    @ApiOperation(value = "注册", notes = "用户注册接口")
    @PostMapping(value = "/register")
    public CommonResult creat(@RequestBody UserRegisterParam param) {
        List<User> tempUser = userService.getExample(param.getUsername());
        if (tempUser.size() != 0) {
            return CommonResult.failed("该用户名已被使用");
        }
        return userService.addUser(param);
    }

    @ApiOperation(value = "获取座位情况", notes = "获取座位情况接口")
    @GetMapping(value = "/seat")
    public CommonResult getSeat() {
        if (seatService.findSeat().size() == 0) {
            CommonResult.failed("没有座位了!");
        }
        return CommonResult.success(seatService.findSeat(),"ok");
    }

    @ApiOperation(value = "预约座位时间情况", notes = "预约座位接口")
    @GetMapping(value = "/seat/order/{id}")
    public CommonResult order(@PathVariable(value = "id") Integer id) {
        return CommonResult.success(seatService.order(id), "ok");
    }

    @ApiOperation(value = "预约座位", notes = "预约座位接口")
    @PostMapping(value = "/seat/order/{id}")
    public CommonResult orderSeat(
            @PathVariable(value = "id") int id,
            @RequestBody List<BookHours> bookHours) {
        seatService.orderSeat(id, bookHours);
        return CommonResult.success("ok");
    }

    @ApiOperation(value = "查看预约历史", notes = "预约历史接口")
    @GetMapping(value = "/history")
    public CommonResult orderHistory(){
        return CommonResult.success(seatService.orderHistory(),"ok");
    }

    @ApiOperation(value = "取消预约", notes = "预约历史接口")
    @PostMapping(value = "/history/cancel")
    public CommonResult cancelOrder(@RequestParam int id){
        seatService.cancelOrder(id);
        return CommonResult.success("ok");
    }


}
