package ru.sydev.serviceautowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaEventService implements IEventService {
    @Override
    public void send(String message) {
        System.out.println("Sending message '" + message + "' via Kafka");
    }
}
