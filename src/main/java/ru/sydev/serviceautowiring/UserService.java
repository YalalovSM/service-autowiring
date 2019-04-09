package ru.sydev.serviceautowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class UserService {
    @Value("${sydev.event.service.name}")
    private String eventServiceName;

    @Autowired
    private BeanFactory beans;

    private IEventService service;

    @PostConstruct
    void postConstruct() {
        try
        {
            service = (IEventService) beans.getBean( eventServiceName );
        }
        catch( BeansException e )
        {
            service = beans.getBean( DefaultEventService.class );
        }
    }

    public void check() {
        service.send("Hello there!");
    }
}
