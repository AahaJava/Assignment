package com.ahb.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.ahb.kafka.AppConstants.GROUP_ID;
import static com.ahb.kafka.AppConstants.TOPIC_NAME;

@Service
public class KafKaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consume(String message) {
        logger.info(String.format("Message recieved -> %s", message));
    }
}