package org.goskyer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 连接工厂类
 * @author: monster_x
 * @create: 2018-09-04 14:45
 **/
public final class RabbitMqConnectionUtil {

    private RabbitMqConnectionUtil() {
        throw new RuntimeException("not allowed create this class...");
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        //factory.setHost("localhost");
        //建立到代理服务器到连接
        System.out.println("连接中...");
        return factory.newConnection();
    }
}
