package ru.sydev.serviceautowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sydev.serviceautowiring.event.DefaultEventService;
import ru.sydev.serviceautowiring.event.EventService;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class EventUsageService {
    @Value("${sydev.event.service}")
    private String serviceName;

    @Autowired
    private BeanFactory beans;

    private EventService eventService;

    @PostConstruct
    void postConstruct() {
        try
        {
            eventService = (EventService) beans.getBean(serviceName);
        }
        catch( BeansException e )
        {
            eventService = beans.getBean( DefaultEventService.class );
        }
    }

    public void check() {
        eventService.send("User created");
    }
}
