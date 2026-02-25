package com.lld.pubsub;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

//@Service
public class RedisSubscriberService {

    public RedisSubscriberService(RedissonClient client) {
        RTopic topic = client.getTopic("news");

        topic.addListener(String.class, (channel, msg) -> {
            System.out.println("Received: " + msg);
        });
    }
}
