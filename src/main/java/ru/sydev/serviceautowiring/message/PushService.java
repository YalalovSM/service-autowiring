package ru.sydev.serviceautowiring.message;

public class PushService implements MessageService {
    @Override
    public void send(String message) {
        System.out.println("Sending message '" + message + "' via Push");
    }
}
