package com.capr.examenlunes.service.impl;

import com.capr.examenlunes.service.SubscriptorConsumerService;
import com.capr.examenlunes.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriptorConsumerServiceImpl implements SubscriptorConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptorConsumerServiceImpl.class);

    @Override
    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void consume(String message) {
        LOGGER.info(String.format("Alerta recibida -> %s", message));
    }
}
