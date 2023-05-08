package com.capr.examenlunes.service;

public interface SubscriptorProducerService {
    void sendMessage(String message, String idUser, String idChanel);
}
