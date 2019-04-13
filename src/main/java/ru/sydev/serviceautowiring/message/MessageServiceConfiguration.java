package ru.sydev.serviceautowiring.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MessageServiceConfiguration {
    @Value("${sydev.message.service:ru.sydev.serviceautowiring.message.MailService}")
    private String serviceName;

    @Bean
    MessageService messageService() {
        Class clazz;

        try {
            clazz = Class.forName(serviceName);
        } catch (ClassNotFoundException e) {
            log.error( "Class {} not found. Using default service", serviceName );
            clazz = DefaultMessageService.class;
        }

        try {
            return (MessageService) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Cannot create a new instance of class {}", clazz.getName(), e);
            return null;
        }
    }
}
