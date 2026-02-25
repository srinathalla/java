package com.lld.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisherService {

    private final RedissonClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public RedisPublisherService(RedissonClient client) {
        this.client = client;
    }

    public void publish(ChatMessage message) {
        try {
            String topicName = "chat:" + message.getChatId();
            RTopic topic = client.getTopic(topicName);

            topic.publish(mapper.writeValueAsString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

