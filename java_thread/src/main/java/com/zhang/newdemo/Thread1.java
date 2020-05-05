package com.zhang.newdemo;

/**
 * 创建线程方法之一：继承thread，重写run方法，start启动线程
 */
public class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("多线程开启==="+i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("学习多线程==="+i);
        }
    }
}
