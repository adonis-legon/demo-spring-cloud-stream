package com.example.demospringcloudstreamproducer.messaging;

import com.example.demospringcloudstreamproducer.domain.Message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(MessageBinding.class)
@Component
public class MessageProducer {

    MessageChannel messageChannel;

    public MessageProducer(MessageBinding messageBinding) {
        messageChannel = messageBinding.messageChannel();
    }

    public void send(Message message) {
        MessageBuilder<Message> messageBuilder = MessageBuilder.withPayload(message);
        messageChannel.send(messageBuilder.build());
    }
}