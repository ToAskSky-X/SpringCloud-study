package org.goskyer.spring;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "spring-boot-exchange";
    public static final String ROUTINGKEY = "spring-boot-routingKey";


    @Bean
    public Queue createQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue directQueue() {
        return new Queue("direct");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

}
