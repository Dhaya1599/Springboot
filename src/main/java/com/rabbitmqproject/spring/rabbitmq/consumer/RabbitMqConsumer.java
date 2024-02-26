package com.rabbitmqproject.spring.rabbitmq.consumer;

import com.rabbitmqproject.spring.rabbitmq.config.RabbitMQConfig;
import com.rabbitmqproject.spring.rabbitmq.entity.OrderDt;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

    @RabbitListener(queues = RabbitMQConfig.Queue)
    public void consume(OrderDt orderDt) {
        System.out.println("Consumer is able to consume the messages from queue"+orderDt);

    }

}