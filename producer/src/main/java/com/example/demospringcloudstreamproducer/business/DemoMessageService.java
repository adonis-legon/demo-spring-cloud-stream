package com.example.demospringcloudstreamproducer.business;

import java.util.UUID;

import com.example.demospringcloudstreamproducer.domain.Message;
import com.example.demospringcloudstreamproducer.messaging.MessageProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoMessageService implements MessageService {

    @Autowired
    MessageProducer messageProducer;

    @Override
    public Message create(String content) {
        Message message = new Message(UUID.randomUUID().toString(), content);
        messageProducer.send(message);

        System.out.println("Message created: " + message.toString());
        return message;
    }
}