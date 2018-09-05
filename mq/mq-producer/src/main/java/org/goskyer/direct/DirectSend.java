package org.goskyer.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.goskyer.RabbitMqConnectionUtil;

/**
 * @description: 消费者
 * @author: monster_x
 * @create: 2018-09-04 15:20
 **/
public class DirectSend {

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = RabbitMqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        // 消息内容
        String message = "删除商品， id = 1001";
        String updateMessage = "更新商品， id = 1002";
        String insertMessage = "添加商品， id = 1003";
       /* channel.basicPublish(EXCHANGE_NAME, "delete", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.basicPublish(EXCHANGE_NAME, "update", null, updateMessage.getBytes());
        System.out.println(" [x] Sent '" + updateMessage + "'");*/

        channel.basicPublish(EXCHANGE_NAME, "insert", null, insertMessage.getBytes());
        System.out.println(" [x] Sent '" + insertMessage + "'");
        channel.close();
        connection.close();
    }
}

