package pers.nasanir.fountain.hr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pers.nasanir")
@MapperScan("pers.nasanir.fountain")

public class HrApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(HrApplicationMain.class, args);
    }
}
