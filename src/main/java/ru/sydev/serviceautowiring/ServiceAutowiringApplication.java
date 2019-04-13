package ru.sydev.serviceautowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServiceAutowiringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(ServiceAutowiringApplication.class, args);
        EventUsageService eventUsageService = (EventUsageService) app.getBean("eventUsageService");
        MessageUsageService messageUsageService = (MessageUsageService) app.getBean("messageUsageService");

        eventUsageService.check();
        messageUsageService.check();
    }
}
