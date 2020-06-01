package com.zhang.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * 发布订阅模式，消费者2 看做是搜索系统
 */
public class Consumer02 {

    private final static String QUEUE_NAME = "test_queue_work2";
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws IOException, InterruptedException {
        //获取链接/通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //通道创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //队列绑定到交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);
        //定义消费者队列
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，手动返回确认信息
        channel.basicConsume(QUEUE_NAME,false,consumer);

        //获取消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String s = new String(delivery.getBody());
            System.out.println("消费者2获取消息===>" + s);
            Thread.sleep(100);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);

        }
    }
}
