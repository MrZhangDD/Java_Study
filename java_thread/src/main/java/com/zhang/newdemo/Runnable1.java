package com.zhang.newdemo;

/**
 * 线程创建2：实现runnable接口
 */
public class Runnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("多线程开启==="+i);
        }
    }

    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();
        new Thread(runnable1).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("学习多线程==="+i);
        }
    }
}
