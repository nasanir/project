package pers.nasanir.fountain.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pers.nasanir")
public class ProjectApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplicationMain.class, args);
    }
}
