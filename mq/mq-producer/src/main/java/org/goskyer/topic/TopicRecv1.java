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

    private final static String QUEUE_NAME = "test_queue_topic_1";

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = RabbitMqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "item.update");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "item.delete");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        // 监听队列，手动返回完成
        boolean autoAck = false;
        String consumerTag = "";
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        while (true) {
            channel.basicConsume(QUEUE_NAME, false, consumer);
        }
        // 获取消息
       /* channel.basicConsume(QUEUE_NAME, autoAck, consumerTag, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                System.out.println("消费的路由键：" + routingKey);
                System.out.println("消费的内容类型：" + contentType);
                long deliveryTag = envelope.getDeliveryTag();
                //确认消息 注意此处boolean 参数
                channel.basicAck(deliveryTag, true);
                System.out.println("消费的消息体内容：");
                String bodyStr = new String(body, "UTF-8");
                System.out.println(bodyStr);
            }
        });*/
    }

}
