package ru.sydev.serviceautowiring.message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultMessageService implements MessageService {
    @Override
    public void send(String message) {
        System.out.println("Use DefaultMessageService. send() is not implemented");
    }
}
