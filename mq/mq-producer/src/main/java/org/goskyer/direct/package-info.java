package org.goskyer.direct;

/*
* rabbitMQ 路由模式(Direct Exchange)代码示例
* 这种模式添加了一个路由键，生产者发布消息的时候添加路由键，消费者绑定队列到交换机时添加键值，这样就可以接收到需要接收的消息。
**/