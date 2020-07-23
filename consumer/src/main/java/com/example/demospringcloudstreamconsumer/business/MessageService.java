package com.example.demospringcloudstreamconsumer.business;

import com.example.demospringcloudstreamconsumer.domain.Message;

public interface MessageService {
    void process(Message message);
}