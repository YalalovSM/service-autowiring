package ru.sydev.serviceautowiring.message;

public class MailService implements MessageService {
    @Override
    public void send(String message) {
        System.out.println("Sending message '" + message + "' via Mail");
    }
}
