package ru.sydev.serviceautowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultEventService implements IEventService {
    @Override
    public void send(String message) {
        log.error("DefaultEventService.send is not implemented");
    }
}
