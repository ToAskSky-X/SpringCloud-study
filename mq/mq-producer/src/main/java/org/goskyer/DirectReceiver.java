package org.goskyer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消息消费者
 * @author: monster_x
 * @create: 2018-08-31 17:42
 **/
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 DirectReceiver," + message);
    }
}

