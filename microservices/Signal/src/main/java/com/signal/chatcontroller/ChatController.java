package com.signal.chatcontroller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chat.model.Message;

@Controller
public class ChatController {
	  @MessageMapping("/send")
	    @SendTo("/topic/messages")
	    public Message sendMessage(Message message) {
	        // Handle message processing
	        return message;
	    }
	}


