package club.banyuan.mall.service;

import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.model.UmsAdmin;
import club.banyuan.mall.dao.param.AdminQueryParam;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminListResponse;
import club.banyuan.mall.dto.UmsAdminUpdatePasswordParam;
import club.banyuan.mall.exception.CommonException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    String login(String username, String password);

    UserDetails loadUserByUsername(String username);

    void createUser(UmsAdminCreateParam param);

    UmsAdminListResponse list(AdminQueryParam param);

    void updatePassword(UmsAdminUpdatePasswordParam passwordParam) throws CommonException;
}
