package com.example.appchat.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ChatController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/sendmessage")
    public String sendMessage(@RequestBody String message) {
        rabbitTemplate.convertAndSend("chat-queue", message);
        return message +" message is send successfuly";
    }
}