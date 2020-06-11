package club.banyuan.mall.dao;

import club.banyuan.mall.common.model.UmsAdmin;
import club.banyuan.mall.dao.param.AdminQueryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UmsAdminDao {
    int count(AdminQueryParam adminQueryParam);
    List<UmsAdmin> findManyByParam(AdminQueryParam adminQueryParam);
    UmsAdmin findOneByParam(String username);
    void updatePassword(@Param("id") Long id, @Param("password") String newPassword);
}
