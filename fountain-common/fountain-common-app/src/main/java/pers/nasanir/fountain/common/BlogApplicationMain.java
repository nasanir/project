package pers.nasanir.fountain.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pers.nasanir")
@MapperScan("pers.nasanir.fountain")
public class BlogApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplicationMain.class, args);
    }
}
