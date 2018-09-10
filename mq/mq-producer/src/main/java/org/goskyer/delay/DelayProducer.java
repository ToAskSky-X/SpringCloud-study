package org.goskyer.delay;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.goskyer.RabbitMqConnectionUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @description: 生产者
 * @author: monster_x
 * @create: 2018-09-04 14:44
 **/
public class DelayProducer {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    private final static String QUEUE = "deply_test";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        System.out.println("DelayProducer message start =========>");
        for (int i = 0; i < 100; i++) {
            Connection connection = RabbitMqConnectionUtil.getConnection();
            send("商品已经新增，id=" + i, connection);
        }
    }

    private static void send(String message, Connection connection) throws IOException, TimeoutException {
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //设置队列的TTL
        Map<String, Object> args = new HashMap<>(4);
        args.put("vhost", "/");
        args.put("username", "root");
        args.put("password", "root");
        args.put("x-message-ttl", 6000);
        channel.queueDeclare(QUEUE, true, false, false, args);

        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        builder.expiration("1000");//设置消息TTL
        builder.deliveryMode(2);//设置消息持久化
        AMQP.BasicProperties properties = builder.build();
        channel.basicPublish("", QUEUE, properties, message.getBytes());
        // 消息内容
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
