package com.example.demospringcloudstreamconsumer.exceptions;

@SuppressWarnings("serial")
public class MessageValidationException extends Exception {
    public MessageValidationException(String messsage) {
        super(messsage);
    }
}