package org.goskyer.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.goskyer.RabbitMqConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 生产者
 * @author: monster_x
 * @create: 2018-08-31 16:06
 **/
public class ProducerDemo {
    public static final String HELLO_EXCHANGE = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);
        channel.queueBind("hello", HELLO_EXCHANGE, "TEST");
        String message = "Hello World!";
        channel.basicPublish(HELLO_EXCHANGE, "hello", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
