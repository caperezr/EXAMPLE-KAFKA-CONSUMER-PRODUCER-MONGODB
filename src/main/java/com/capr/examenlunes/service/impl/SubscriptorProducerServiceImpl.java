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

import java.util.ArrayList;
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
        Chanel channel = chanelRepository.findById(idChanel)
                .orElseThrow(() -> new IllegalArgumentException("Canal no encontrado"));

        Optional<User> userOptional = userRepository.findById(idUser);
        User user = userOptional.get();

        if (channel.getSubscribersList() == null) {
            channel.setSubscribersList(new ArrayList<>());
        }

        if (!channel.getSubscribersList().contains(user)) {
            channel.getSubscribersList().add(user);
            channel.setSubscribers(channel.getSubscribersList().size());
            chanelRepository.save(channel);
            message = user.getName()+" bienvenido al canal "+channel.getName() + " somos una familia muy grande contamos con "+channel.getSubscribers()+ " miembros";
        } else {
            message = user.getName()+" usted ya se encuentra suscrito al canal";
        }

        LOGGER.info(String.format("Alerta enviada -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }

}
