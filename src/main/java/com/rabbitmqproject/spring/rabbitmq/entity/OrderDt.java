package com.rabbitmqproject.spring.rabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDt {

    private Order order;
    private String orderStatus;
    private String messages;


}
