package com.lld.pubsub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/redis")
public class RedisController {

    private final RedisPublisherService publisher;

    public RedisController(RedisPublisherService publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/send")
    public String send(@RequestParam String msg) {
        publisher.publish(msg);
        return "Message sent: " + msg;
    }
}
