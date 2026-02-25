package com.lld.pubsub;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

//@Service
public class RedisPublisherService {

    private final RTopic topic;

    public RedisPublisherService(RedissonClient client) {
        this.topic = client.getTopic("news");
    }

    public void publish(String message) {
        topic.publish(message);
    }
}
