package com.zhang.syncdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 *ReentrantLock 可重入锁
 */
public class LockDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}

class Ticket implements Runnable{
    int num = 10;
    private final ReentrantLock lock  = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(num > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num--);
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }

    }
}
