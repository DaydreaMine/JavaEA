package club.banyuan.sr.dao;

import club.banyuan.sr.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserFuckDao {
    User findByUserName(@Param("username") String username);
    List<User> getUser();
}
