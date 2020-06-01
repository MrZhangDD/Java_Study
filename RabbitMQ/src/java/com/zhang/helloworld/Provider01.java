package com.zhang.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * 简单模式的生产者
 */
public class Provider01 {
    private static final String QUEUE_NAME = "test01Queue";

    public static void main(String[] args) throws IOException {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2.通过连接创建通道
        Channel channel = connection.createChannel();
        //3.通道创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //4.创建消息内容绑定到通道
        String msg = "MQ简单模式";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        System.out.println("==》发送消息"+msg);
        //5.关闭通道和连接
        channel.close();
        connection.close();
    }
}
