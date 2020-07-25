package com.example.demospringcloudstreamconsumer.business;

import java.util.Random;

import com.example.demospringcloudstreamconsumer.domain.Message;
import com.example.demospringcloudstreamconsumer.exceptions.ExternalServiceException;
import com.example.demospringcloudstreamconsumer.exceptions.MessageValidationException;

import org.springframework.stereotype.Service;

@Service
public class DemoMessageService implements MessageService {

    @Override
    public Boolean process(Message message) throws MessageValidationException, ExternalServiceException {
        // Perform message validation
        if (message.getContent().length() > 10) {
            // this exception is not configured for consumer retry
            throw new MessageValidationException("Message content is too large");
        }

        // Simulate external service intermittence
        if (new Random().nextInt(100) % 3 == 0) {
            // this exception is configured for consumer retry
            throw new ExternalServiceException();
        }

        // Simulate message that needs to be re-enqueued
        if (new Random().nextInt(100) % 2 == 0) {
            return false;
        }

        // Perform message processing
        int contentWordCount = message.getContent().split(" ").length;
        System.out.println(String.format("Message content has %s word(s)", contentWordCount));

        return true;
    }

}