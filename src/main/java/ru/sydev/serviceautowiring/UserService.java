package ru.sydev.serviceautowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Qualifier("activeMQEventService")
    @Autowired
    private IEventService activeMQEventService;

    @Qualifier("kafkaEventService")
    @Autowired
    private IEventService kafkaEventService;

    @Value("${service.class}")
    private String className;

    public IEventService getEventService() {
        IEventService service = null;
        switch (className) {
            case "activeMQEventService":
                service = activeMQEventService;
                break;
            case "kafkaEventService":
                service = kafkaEventService;
        }

        return service;
    }

    public void check() {
        getEventService().send("Hello there!");
    }
}
