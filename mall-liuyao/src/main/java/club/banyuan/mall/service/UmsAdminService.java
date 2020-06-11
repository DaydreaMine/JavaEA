package club.banyuan.mall.service;

import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.model.UmsAdmin;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import org.springframework.security.core.userdetails.UserDetails;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    String login(String username,String password);

    UserDetails loadUserByUsername(String username);

    void createUser(UmsAdminCreateParam param);
}
