package com.example.demospringcloudstreamproducer.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageBinding {
    String CHANNEL = "messageChannel";

    @Output(CHANNEL)
    MessageChannel messageChannel();
}