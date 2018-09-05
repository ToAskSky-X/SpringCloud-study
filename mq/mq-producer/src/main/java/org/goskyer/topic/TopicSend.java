package org.goskyer.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.goskyer.RabbitMqConnectionUtil;

/**
 * @description: 生产者
 * @author: monster_x
 * @create: 2018-09-04 18:44
 **/
public class TopicSend {


    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = RabbitMqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        // 消息内容
        String message = "删除商品，id = 2222";
        channel.basicPublish(EXCHANGE_NAME, "item.delete", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
