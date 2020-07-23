package com.example.demospringcloudstreamproducer.api;

import com.example.demospringcloudstreamproducer.business.MessageService;
import com.example.demospringcloudstreamproducer.domain.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("")
    public ResponseEntity<Message> createMessage(@RequestBody String content) {
        return new ResponseEntity<Message>(messageService.create(content), HttpStatus.CREATED);
    }
}