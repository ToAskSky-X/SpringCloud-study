package org.goskyer.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 生产者
 * @author: monster_x
 * @create: 2018-08-31 16:06
 **/
public class ProducerDemo {
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5672);
        //设置 RabbitMQ 地址
        factory.setHost("localhost");
        System.out.println("连接中。。。");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        System.out.println("连接成功。。。");
        //获得信道
        Channel channel = conn.createChannel();
        channel.queueDeclare("hello", false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", "hello", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }
}
