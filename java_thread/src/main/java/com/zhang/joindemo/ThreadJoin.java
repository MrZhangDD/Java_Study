package com.zhang.joindemo;

/**
 * 模拟线程插队（会造成阻塞）
 */
public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("thread-》"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        //主线程中插入threa
        for (int i = 0; i < 500; i++) {
            if(i==100){
                thread.join(); //插队
            }
            System.out.println("main-》"+i);

        }
    }
}
