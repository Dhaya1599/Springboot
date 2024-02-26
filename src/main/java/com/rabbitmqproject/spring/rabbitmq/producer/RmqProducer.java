package com.rabbitmqproject.spring.rabbitmq.producer;


import com.rabbitmqproject.spring.rabbitmq.config.RabbitMQConfig;
import com.rabbitmqproject.spring.rabbitmq.entity.Order;
import com.rabbitmqproject.spring.rabbitmq.entity.OrderDt;
import com.rabbitmqproject.spring.rabbitmq.entity.OrderRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
    public OrderDt placeOrder(@RequestBody OrderRequest orderRequest)
    {
        Order order= new Order(orderRequest.id(), orderRequest.name(), orderRequest.price(), orderRequest.quantity());
        OrderDt orderdt = new OrderDt(order,"Order Placed", "Hi Producer, ur order is placed");
        System.out.println(order.getId());
        System.out.println(order.getName());
        System.out.println(order.getPrice());

        rabbitTemplate.convertAndSend(RabbitMQConfig.Exchange, RabbitMQConfig.Routing_key, orderdt);

        return orderdt;

    }
}
