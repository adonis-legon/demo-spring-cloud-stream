package com.example.demospringcloudstreamconsumer.messaging;

import com.example.demospringcloudstreamconsumer.domain.Message;
import com.rabbitmq.client.Channel;

import com.example.demospringcloudstreamconsumer.business.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;

@EnableBinding(MessageBinding.class)
public class MessageConsumer {

    final String messageDlq = "messages.messages-group.dlq";

    @Autowired
    MessageService messageService;

    @StreamListener(target = MessageBinding.CHANNEL)
    void handleMessageReceived(Message message, @Header(AmqpHeaders.CHANNEL) Channel channel,
            @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws Exception {
        // Manual ACK and in case of error, throw an Exception that will be retried or
        // directly sent to the DLQ depending on the consumer configuration

        // process Message usig business service
        messageService.process(message);

        // ACK a successfuly processed Message
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = { messageDlq })
    void handleErrorMessageReceived(org.springframework.amqp.core.Message message) throws Exception {

        // Process error messages according to business rules
        String messagePayload = new String(message.getBody());
        System.out.println(String.format("Error message has being reprocessed. Payload: %s", messagePayload));
    }
}