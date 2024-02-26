package com.rabbitmqproject.spring.rabbitmq.producer;


import com.rabbitmqproject.spring.rabbitmq.config.RabbitMQConfig;
import com.rabbitmqproject.spring.rabbitmq.entity.OrderDt;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RmqProducer {

    @Autowired
    private RabbitTemplate  rabbitTemplate;

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order)
    {
        OrderDt orderdt = new OrderDt(order,"Order Placed", "Hi Producer, ur order is placed");

        rabbitTemplate.convertAndSend(RabbitMQConfig.Exchange, RabbitMQConfig.Routing_key, orderdt);

        return ResponseEntity.ok().body("Order Placed");

    }
}
