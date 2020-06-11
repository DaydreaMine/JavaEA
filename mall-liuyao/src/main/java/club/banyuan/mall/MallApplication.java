package club.banyuan.mall;

import club.banyuan.mall.common.mapper.UmsRoleMapper;
import club.banyuan.mall.common.model.UmsRole;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Hello world!
 */
@MapperScan({"club.banyuan.mall.common.mapper"})
@SpringBootApplication
@RestController

public class MallApplication {
    @Autowired
    private UmsRoleMapper roleMapper;
    public static void main(String[] args) {
     SpringApplication.run(MallApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @GetMapping(value = "/")
    public String out(){
//                UmsRole role = new UmsRole();
//        role.setName("管理员");
//        role.setDescription("管理员不用介绍");
//        role.setStatus(true);
//        role.setCreateTime(new Date());
//        roleMapper.insert(role);
        UmsRole umsRole=roleMapper.selectByPrimaryKey(2l);
        return "<p>" + umsRole.toString() + "</p>";
//        return "hello world";
    }

}
