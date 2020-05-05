package com.zhang.syncdemo;

/**
 * 模拟死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0,"小泥人");
        Makeup makeup2 = new Makeup(2,"白雪公主");
        makeup.start();
        makeup2.start();
    }
}
//镜子
class Mirror{}
//化妆品
class Lipstick{}

class Makeup extends Thread{
    //static保证只有一份
    static Mirror mirror = new Mirror();
    static Lipstick lipstick = new Lipstick();
    int choice; //选择
    String name; //人物
    public Makeup(int choice,String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //死锁
    private void makeup() throws InterruptedException {
        if(choice == 0){
            //先拿化妆品
            synchronized (lipstick){
                System.out.println(this.name+"拿到化妆品");
                Thread.sleep(1000);
                synchronized (mirror){ //再去拿镜子
                    System.out.println(this.name+"拿到镜子");
                }
            }
        } else {
            //先拿镜子
            synchronized (mirror){
                System.out.println(this.name+"拿到镜子");
                Thread.sleep(2000);
                synchronized (lipstick){ //再去拿化妆品
                    System.out.println(this.name+"拿到化妆品");
                }
            }
        }
    }

    //避免死锁
    private void makeup2() throws InterruptedException {
        if(choice == 0){
            //先拿化妆品
            synchronized (lipstick){
                System.out.println(this.name+"拿到化妆品");
                Thread.sleep(1000);
            }
            synchronized (mirror){ //再去拿镜子
                System.out.println(this.name+"拿到镜子");
            }
        } else {
            //先拿镜子
            synchronized (mirror){
                System.out.println(this.name+"拿到镜子");
                Thread.sleep(2000);
            }
            synchronized (lipstick){ //再去拿化妆品
                System.out.println(this.name+"拿到化妆品");
            }
        }
    }
}