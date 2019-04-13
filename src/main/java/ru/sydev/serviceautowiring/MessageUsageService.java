package ru.sydev.serviceautowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sydev.serviceautowiring.event.DefaultEventService;
import ru.sydev.serviceautowiring.event.EventService;
import ru.sydev.serviceautowiring.message.MessageService;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class MessageUsageService {
    @Autowired
    private MessageService messageService;

    public void check() {
        messageService.send("Server is up");
    }
}
