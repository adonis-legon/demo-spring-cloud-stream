package com.example.demospringcloudstreamconsumer.business;

import com.example.demospringcloudstreamconsumer.domain.Message;

import org.springframework.stereotype.Service;

@Service
public class StreamMessageService implements MessageService {

    @Override
    public void process(Message message) {
        System.out.println("Message processed: " + message.toString());
    }

}