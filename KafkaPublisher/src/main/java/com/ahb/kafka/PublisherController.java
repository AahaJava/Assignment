package com.ahb.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class PublisherController {

    @Autowired
    KafkaSender kafkaSender;
    String kafkaTopic = "my-topic";

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaSender.send(kafkaTopic, message);

        return "Message sent to the Kafka Topic my-topic Successfully";
    }

    @GetMapping(value = "/get")
    public String test(){
        return "Kafka";
    }
}
