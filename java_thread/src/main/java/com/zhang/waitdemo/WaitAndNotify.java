package com.zhang.waitdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * 测试WaitAndNotify
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        Producer producer = new Producer(synContainer);
        Consumer consumer = new Consumer(synContainer);
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}

//生产者
class Producer implements Runnable{
    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class  Consumer implements Runnable{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+synContainer.pop().id+"只鸡");
        }
    }
}

//消费的东西
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
//容器
class SynContainer{
    //容量的大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int i = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //判断是否满了
        if(i == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[i] = chicken;
        i++;
        //通知消费者消费
        this.notifyAll();
    }
    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if(i == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        i--;
        Chicken chicken = chickens[i];
        //通知生产者生产
        this.notifyAll();
        return chicken;
    }
}