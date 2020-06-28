package club.banyuan.sr.controller.api;

import club.banyuan.sr.common.api.CommonResult;
import club.banyuan.sr.dto.AdminLogionParam;
import club.banyuan.sr.dto.CancelSeatParam;
import club.banyuan.sr.dto.SeatStatusParam;
import club.banyuan.sr.dto.UserLoginParam;
import club.banyuan.sr.mapper.SeatMapper;
import club.banyuan.sr.model.Seat;
import club.banyuan.sr.model.SeatRecordExample;
import club.banyuan.sr.model.User;
import club.banyuan.sr.service.SeatService;
import club.banyuan.sr.service.SeatServiceImpl;
import club.banyuan.sr.service.UserService;
import cn.hutool.crypto.digest.BCrypt;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "AdminController", description = "管理员接口")
@RequestMapping(value = "/ums")
@RestController
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    SeatServiceImpl seatService;

//    @PostMapping("/admin/login")
//    public CommonResult login(@RequestBody UserLoginParam param, HttpServletRequest request) {
//
//        List<User> tempUser = userService.getExample(param.getUsername());
//        if (tempUser.size() == 0) {
//            return CommonResult.failed("没有此用户");
//        }
//        User user = tempUser.get(0);
//        try {
//            if (!BCrypt.checkpw(param.getPassword(), user.getPassword())) {
//                return CommonResult.failed("密码错误！[99982]");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return CommonResult.failed("密码错误！[99983]");
//        }
//
//        String role = "Role_Admin";
//        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
//        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getPassword(), authorities
//        );
//        PreAuthenticatedAuthenticationToken authenticationToken = new PreAuthenticatedAuthenticationToken(
//                userDetails, userDetails.getPassword(), userDetails.getAuthorities()
//        );
//
//        authenticationToken.setDetails(new WebAuthenticationDetails(request));
//        //存入authenticationToken进context(即用authenticationToken替代session)
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//        return CommonResult.success("登录成功");
//    }

    @GetMapping("/admin/getUser")
    //获取当前用户
    public CommonResult getUser() {
        return CommonResult.success(seatService.select(), "ok");
    }

    @GetMapping("/admin/getSeat")
    //获取当前座位
    public CommonResult getSeat() {
        return CommonResult.success(seatService.getSeat(), "OK");
    }

    @PostMapping("/admin/changeSeat")
    //改变座位状态
    public CommonResult change(@RequestBody SeatStatusParam param) {
        seatService.changeStatus(param);
        return CommonResult.success(seatService.getSeat(), "OK");
    }

    //添加座位
    @PostMapping("admin/addSeat")
    public CommonResult add(@RequestBody Seat seat) {
        seatService.addSeat(seat);
        return CommonResult.success("OK");
    }

    //获取全部用户预订信息
    @GetMapping("/admin/records")
    public CommonResult getRecords() {
        return CommonResult.success(seatService.getRecords(), "ok");
    }

    //取消用户预约情况
    @PostMapping("/admin/cancelRecords")
    public String cancelRecords(@RequestBody CancelSeatParam param) {
        seatService.cancelRecords(param);
        return "redirect:/admin/records";

    }
}
