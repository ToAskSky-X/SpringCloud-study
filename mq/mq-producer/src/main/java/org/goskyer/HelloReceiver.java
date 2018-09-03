package org.goskyer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消息消费者
 * @author: monster_x
 * @create: 2018-08-31 17:41
 **/
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 helloReceiver," + message);
    }
}