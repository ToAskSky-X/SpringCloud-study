package org.goskyer.topic;

import com.rabbitmq.client.*;
import org.goskyer.RabbitMqConnectionUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @description: 消费者
 * @author: monster_x
 * @create: 2018-09-04 18:47
 **/
public class TopicRecv1 {

    private final static String QUEUE_NAME = "test_queue_topic_2";

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = RabbitMqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "item.broadcast");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "item.a");
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }

}
