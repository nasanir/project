package pers.nasanir.fountain.hr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import pers.nasanir.fountain.common.common.utils.AppServiceHelper;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication(scanBasePackages = "pers.nasanir")
@MapperScan("pers.nasanir.fountain")
public class HrApplicationMain {
    public static void main(String[] args) {
        ApplicationContext ctx=run(HrApplicationMain.class, args);
        AppServiceHelper.setApplicationContext(ctx);
    }
}
