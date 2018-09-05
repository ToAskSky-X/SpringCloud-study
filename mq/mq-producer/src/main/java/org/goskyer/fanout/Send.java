package org.goskyer.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.goskyer.RabbitMqConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 生产者
 * @author: monster_x
 * @create: 2018-09-04 14:44
 **/
public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        System.out.println("Send message start =========>");
        for (int i = 0; i < 100; i++) {
            Connection connection = RabbitMqConnectionUtil.getConnection();
            send("商品已经新增，id=" + i, connection);
        }
    }

    private static void send(String message, Connection connection) throws IOException, TimeoutException {
        //从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 消息内容
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
