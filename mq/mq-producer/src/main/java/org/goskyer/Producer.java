package org.goskyer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class
Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello" + LocalDate.now();
        System.out.println("sender:" + context);
        amqpTemplate.convertAndSend("hello", context);
    }
}
