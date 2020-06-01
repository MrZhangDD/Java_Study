package com.zhang.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhang.ConnectionUtil;

import java.io.IOException;

/**
 * 生产者生产消息
 */
public class Provider {
    private static final String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws IOException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        for (int i = 0; i < 50; i++) {
            //消息内容
            String msg = ""+i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("生产消息===》"+i);
            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }
}
