package com.capr.examenlunes.service.impl;

import com.capr.examenlunes.model.Chanel;
import com.capr.examenlunes.model.User;
import com.capr.examenlunes.repository.ChanelRepository;
import com.capr.examenlunes.repository.UserRepository;
import com.capr.examenlunes.service.SubscriptorProducerService;
import com.capr.examenlunes.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptorProducerServiceImpl implements SubscriptorProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptorProducerServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChanelRepository chanelRepository;

    @Override
    public void sendMessage(String message, String idUser, String idChanel) {
        Optional<User> userOptional = userRepository.findById(idUser);
        User user = userOptional.get();

        Optional<Chanel> chanelOptional = chanelRepository.findById(idChanel);
        Chanel chanel = chanelOptional.get();

        message = user.getName()+" bienvenido al canal "+chanel.getName() + " somos una familia muy grande contamos con "+chanel.getSubscribers()+ " miembros";


        LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }
}
