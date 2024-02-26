package com.rabbitmqproject.spring.rabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
public class OrderDt {

    private Order order;
    private String orderStatus;
    private String messages;


    public OrderDt(com.rabbitmqproject.spring.rabbitmq.entity.Order order, String orderPlaced, String messages) {
        this.order= order;
        this.orderStatus=orderPlaced;
        this.messages=messages;
    }
}
