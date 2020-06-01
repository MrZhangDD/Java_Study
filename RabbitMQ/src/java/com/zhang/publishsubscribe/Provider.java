package com.zhang.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * 发布订阅模式生产者
 */
public class Provider {
    private static final String EXCHAGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHAGE_NAME,"fanout");
        //消息内容
        String msg = "exchage msg";
        channel.basicPublish(EXCHAGE_NAME,"",null,msg.getBytes());
        System.out.println("发布订阅模式，生产者启动===》"+msg);
        channel.close();
        connection.close();
    }

}
