package com.rabbitmqproject.spring.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String Queue = "rabbit_queue";

    public static final String Exchange = "rabbit_exchange";

    public static final String Routing_key = "rabbit_routing_key";

    @Bean
    public Queue queue()
    {
        return new Queue(Queue);
    }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(Exchange);
    }

   @Bean
   public Binding binding(Queue queue, DirectExchange directExchange)
   {
       return BindingBuilder.bind(queue).to(directExchange).with(Routing_key);
   }

    @Bean
    public MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate getTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate  = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }



}
