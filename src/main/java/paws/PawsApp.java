package paws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = "classpath:application.yml")
public class PawsApp {
    public static void main(String[] args) {
        SpringApplication.run(PawsApp.class, args);
    }
}
