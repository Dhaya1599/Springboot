package com.rabbitmqproject.spring.rabbitmq.entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class Order {
    private Integer id;
    private String name;
    private Integer price;
    private Integer quantity;

}
