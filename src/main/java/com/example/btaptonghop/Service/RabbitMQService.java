package com.example.btaptonghop.Service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    private final AmqpTemplate amqpTemplate;

    public RabbitMQService(AmqpTemplate amqpTemplate){
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String message){
        amqpTemplate.convertAndSend("myQueue",message);
    }
}
