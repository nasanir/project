package pers.nasanir.fountain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pers.nasanir")
@MapperScan("pers.nasanir.fountain")
public class ToolsApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ToolsApplicationMain.class, args);
    }
}
