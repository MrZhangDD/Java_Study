package com.zhang.newdemo;

/**
 * 多个线程操作一个对象
 * 买火车票
 * 多个线程同时操作同一个资源会出现线程不安全
 */
public class Runnable3 implements Runnable{
    //票数
    private int ticketCount = 10;
    @Override
    public void run() {
        while (true){
            if(ticketCount<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程："+Thread.currentThread().getName()+"拿到第"+ticketCount--+"票");
        }
    }

    public static void main(String[] args) {
        Runnable3 runnable3 = new Runnable3();
        new Thread(runnable3,"小明").start();
        new Thread(runnable3,"老师").start();
        new Thread(runnable3,"黄牛党").start();
    }
}
