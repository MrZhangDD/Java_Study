package com.zhang.syncdemo;

/**
 * 模拟不安全的买票
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"A").start();
        new Thread(buyTicket,"B").start();
        new Thread(buyTicket,"C").start();
    }

}

class BuyTicket implements Runnable{
    private static int num = 10; //票数
    private boolean flag = true; //停止标记
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    //synchronized锁的是当前对象this
    synchronized void buy() throws InterruptedException {
        if(num <=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到"+num--);
    }

}

