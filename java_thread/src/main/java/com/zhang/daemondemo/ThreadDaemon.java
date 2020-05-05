package com.zhang.daemondemo;

import javax.swing.*;

public class ThreadDaemon {
    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//设置上帝为守护线程
        thread.start();
        You you = new You();
        new Thread(you).start();
    }
}

//守护线程
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝守护着你");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("开开心心活着，——>"+i);
        }
        System.out.println("==goodbye world");
    }
}