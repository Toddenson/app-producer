package com.anbooka.app.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final KafkaTemplate kafkaTemplate;

    public MessageController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(path = "/send/msg/{text}")
    public void sendFoo(@PathVariable String text) {
        this.kafkaTemplate.send("topic1", text);
    }
}
