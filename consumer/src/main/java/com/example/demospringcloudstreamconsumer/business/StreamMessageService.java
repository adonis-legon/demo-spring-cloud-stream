package com.example.demospringcloudstreamconsumer.business;

import java.util.Random;

import com.example.demospringcloudstreamconsumer.domain.Message;
import com.example.demospringcloudstreamconsumer.exceptions.ExternalServiceException;
import com.example.demospringcloudstreamconsumer.exceptions.MessageValidationException;

import org.springframework.stereotype.Service;

@Service
public class StreamMessageService implements MessageService {

    @Override
    public void process(Message message) throws MessageValidationException, ExternalServiceException {
        if (message.getContent().length() > 10) {
            throw new MessageValidationException("Message content is too large");
        }

        // Simulate external service intermittence
        if (new Random().nextInt(100) % 3 == 0) {
            throw new ExternalServiceException();
        }

        System.out.println("Message processed: " + message.toString());
    }

}