package club.banyuan.sr.config;

import club.banyuan.sr.common.api.CommonResult;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

//    @Autowired
//    DatabaseUserDetailsService userDetails;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,role from user WHERE username=?")
//                .authoritiesByUsernameQuery("select username,role as authority from authorities where username=?")
//                .passwordEncoder(new BCryptPasswordEncoder());
//        auth.userDetailsService(userDetails);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        // 获取配置 registry
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        String[] allowList = {
                "/actuator/**",
                "/static/**",
                "/**.js",
                "/**.css",
                "/**.jpg",
                "/**.jpeg",
                "/**.png",
                "/**.gif",
                "/studyroom/**",
                "/api/user/login",
                "/api/user/lgout",
                "/api/user/register",
        };

        http//开启登录配置
                .authorizeRequests()
                .antMatchers("/api/user").hasAuthority("user")//表示访问 /user 这个接口，需要具备 user 这个角色
                .antMatchers("/ums/admin").hasAuthority("admin")//表示访问 /admin 这个接口，需要具备 admin 这个角色
                .antMatchers(allowList).permitAll()
                .anyRequest().authenticated()//表示剩余的其他接口，登录之后就能访问

                .and()
                .formLogin()

                .and()
                .httpBasic()
                .and()
                .csrf().disable()

                .exceptionHandling()
                //认证过的用户访问无权限资源时的异常
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        if (httpServletRequest.getRequestURI().contains("/api")) {
                            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                            httpServletResponse.setHeader("Cache-Control", "no-cache");
                            httpServletResponse.setCharacterEncoding("UTF-8");
                            httpServletResponse.setContentType("application/json");
                            httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
                            httpServletResponse.getWriter().flush();
                        } else {
                            httpServletResponse.sendRedirect("/forbidden");
                        }
                    }
                })
                //未认证过的用户访问无权限资源时的异常
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        if (httpServletRequest.getRequestURI().contains("/api")) {
                            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                            httpServletResponse.setHeader("Cache-Control", "no-cache");
                            httpServletResponse.setCharacterEncoding("UTF-8");
                            httpServletResponse.setContentType("application/json");
                            httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
                            httpServletResponse.getWriter().flush();
                        } else {
                            httpServletResponse.sendRedirect("/api/user/login");
                        }
                    }
                });
    }

}
