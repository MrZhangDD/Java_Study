package com.zhang.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * 路由模式  生产者
 */
public class Provider {
    private static final String EXCHAGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHAGE_NAME,"direct");
        //消息内容
        String msg = "delete msg";
        channel.basicPublish(EXCHAGE_NAME,"delete",null,msg.getBytes());
        System.out.println("路由模式，生产者启动===》"+msg);
        channel.close();
        connection.close();
    }

}
