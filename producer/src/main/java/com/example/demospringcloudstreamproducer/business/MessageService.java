package com.example.demospringcloudstreamproducer.business;

import com.example.demospringcloudstreamproducer.domain.Message;

public interface MessageService {
    Message create(String content);
}