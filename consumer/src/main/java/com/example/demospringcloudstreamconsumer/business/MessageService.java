package com.example.demospringcloudstreamconsumer.business;

import com.example.demospringcloudstreamconsumer.domain.Message;
import com.example.demospringcloudstreamconsumer.exceptions.ExternalServiceException;
import com.example.demospringcloudstreamconsumer.exceptions.MessageValidationException;

public interface MessageService {
    Boolean process(Message message) throws MessageValidationException, ExternalServiceException;
}