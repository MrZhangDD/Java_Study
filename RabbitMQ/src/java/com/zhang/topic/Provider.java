package com.zhang.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * topic模式  生产者
 */
public class Provider {
    private static final String EXCHAGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHAGE_NAME,"topic");
        //消息内容
        String msg = "hello topic";
        channel.basicPublish(EXCHAGE_NAME,"routekey.1.1",null,msg.getBytes());
        System.out.println("topic模式，生产者启动===》"+msg);
        channel.close();
        connection.close();
    }

}
