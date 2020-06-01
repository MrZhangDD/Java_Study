package com.zhang.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * 简单模式的消费者
 */
public class Consumer01 {
    private static final String QUEUE_NAME = "test01Queue";

    public static void main(String[] args) throws IOException, InterruptedException {
        //消费者也需要获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建MQ通道
        Channel channel = connection.createChannel();
        //通过通道声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);
        //获取消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("===>consumer:"+msg);
        }
    }
}
