package com.capr.examenlunes.controller;

import com.capr.examenlunes.service.SubscriptorProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/subscriptions")
public class SubscriptionProducerController {
    @Autowired
    private SubscriptorProducerService subscriptorProducerService;

    @GetMapping("/{userId}/{channelId}/{message}")
    public ResponseEntity<String> publish(@PathVariable("userId") String userId,
                                          @PathVariable("channelId") String channelId,
                                          @PathVariable("message") String message){
        subscriptorProducerService.sendMessage(message, userId, channelId);
        return ResponseEntity.ok("Mensaje enviado al tópico de Kafka");
    }




}
