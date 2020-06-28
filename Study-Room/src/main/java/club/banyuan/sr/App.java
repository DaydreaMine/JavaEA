package club.banyuan.sr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Hello world!
 *
 */
@MapperScan({"club.banyuan.sr.mapper", "club.banyuan.sr.dao"})
@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
