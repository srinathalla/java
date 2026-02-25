package com.lld.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisSubscriberService {

    private final SimpMessagingTemplate messagingTemplate;
    private final RedissonClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public RedisSubscriberService(
            SimpMessagingTemplate messagingTemplate,
            RedissonClient client) {

        this.messagingTemplate = messagingTemplate;
        this.client = client;

        subscribeToChat("1001"); // example chat
    }

    public void subscribeToChat(String chatId) {
        String topicName = "chat:" + chatId;

        RTopic topic = client.getTopic(topicName);

        topic.addListener(String.class, (channel, msg) -> {
            try {
                ChatMessage message =
                        mapper.readValue(msg, ChatMessage.class);

                messagingTemplate.convertAndSend(
                        "/topic/chat/" + message.getChatId(),
                        message
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

