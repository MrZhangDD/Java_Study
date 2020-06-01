package com.zhang;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * 通用获取MQ连接
 */
public class ConnectionUtil {
    public static Connection getConnection() throws IOException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置ip
        factory.setHost("localhost");
        //设置端口
        factory.setPort(5672);
        //设置账号密码
        factory.setUsername("admin");
        factory.setPassword("admin");
        //设置vhost,和客户端设置的保持一致
        factory.setVirtualHost("testHost");
        //获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
