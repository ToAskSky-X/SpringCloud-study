package org.goskyer.fanout;

import com.rabbitmq.client.*;
import org.goskyer.RabbitMqConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 消费者
 * @author: monster_x
 * @create: 2018-08-31 16:07
 **/
public class ConsumerDemo {

    private static final String HELLO_EXCHANGE = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqConnectionUtil.getConnection();
        //获得信道
        final Channel channel = connection.createChannel();
        //声明交换器
        channel.exchangeDeclare(HELLO_EXCHANGE, "fanout");
        //声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "TEST";
        //绑定队列，通过键 hello 将队列和交换器绑定起来
        channel.queueBind(queueName, HELLO_EXCHANGE, routingKey);

        channel.queueDeclare("hello", false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume("hello", true, consumer);
        //消费消息
        boolean autoAck = false;
        String consumerTag = "";
        /*channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
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
