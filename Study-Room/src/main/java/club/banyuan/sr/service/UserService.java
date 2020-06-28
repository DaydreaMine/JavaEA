package club.banyuan.sr.service;

import club.banyuan.sr.common.api.CommonResult;
import club.banyuan.sr.dto.UserRegisterParam;
import club.banyuan.sr.model.User;

import java.util.List;

public interface UserService {
    List<User> getExample(String username);
    CommonResult addUser(UserRegisterParam param);

}
