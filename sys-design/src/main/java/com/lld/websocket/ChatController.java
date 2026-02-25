package com.lld.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final RedisPublisherService publisher;

    public ChatController(RedisPublisherService publisher) {
        this.publisher = publisher;
    }

    @MessageMapping("/chat.send")
    public void sendMessage(ChatMessage message) {
        publisher.publish(message);
    }
}
