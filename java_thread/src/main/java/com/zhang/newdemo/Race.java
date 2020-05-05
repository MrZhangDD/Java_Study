package com.zhang.newdemo;

/**
 * 模拟龟兔赛跑
 */
public class Race implements Runnable{
    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子") && i%5==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(gameOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--跑了+"+i+"步");
        }
    }

    public boolean gameOver(int step){
        if(winner != null){
            return true;
        }
        if(step >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("胜利者："+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
