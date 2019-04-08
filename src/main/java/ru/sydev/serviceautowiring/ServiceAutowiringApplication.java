package ru.sydev.serviceautowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServiceAutowiringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(ServiceAutowiringApplication.class, args);
        UserService service = (UserService) app.getBean("userService");
        service.check();
    }
}
