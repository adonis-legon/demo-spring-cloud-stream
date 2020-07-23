package com.example.demospringcloudstreamconsumer.messaging;

import com.example.demospringcloudstreamconsumer.domain.Message;
import com.example.demospringcloudstreamconsumer.business.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MessageBinding.class)
public class MessageConsumer {

    @Autowired
    MessageService messageService;

    @StreamListener(target = MessageBinding.CHANNEL)
    void handleMessageReceived(Message message) {
        messageService.process(message);
    }
}