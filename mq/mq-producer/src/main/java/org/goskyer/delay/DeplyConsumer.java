package org.goskyer.delay;

import com.rabbitmq.client.*;
import org.goskyer.RabbitMqConnectionUtil;

import java.io.IOException;

/**
 * @description: 消费者
 * @author: monster_x
 * @create: 2018-09-04 15:08
 **/
public class DeplyConsumer {

    private final static String QUEUE = "deply_test";


    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = RabbitMqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 定义队列的消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE, true, consumer);
    }
}
