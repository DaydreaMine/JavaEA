package club.banyuan.sr.service;

import club.banyuan.sr.common.api.CommonResult;
import club.banyuan.sr.dao.UserFuckDao;
import club.banyuan.sr.dto.UserRegisterParam;
import club.banyuan.sr.mapper.UserMapper;
import club.banyuan.sr.model.User;
import club.banyuan.sr.model.UserExample;
import cn.hutool.crypto.digest.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserFuckDao userFuckDao;

    @Autowired
    UserMapper userMapper;



    @Override
    public List<User> getExample(String username) {
        UserExample example=new UserExample();

        example.createCriteria().andUsernameEqualTo(username);
        List<User> tempUser = userMapper.selectByExample(example);
        return tempUser;
    }

    @Override
    public CommonResult<Object> addUser(UserRegisterParam param) {
        User user = new User();
        BeanUtils.copyProperties(param,user);
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return CommonResult.failed("注册失败!");
        }
        String passwordHash = BCrypt.hashpw(user.getPassword());
        user.setPassword(passwordHash);
        user.setRole("user");
        userMapper.insert(user);
        return CommonResult.success("注册成功!");
    }
}
