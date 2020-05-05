package com.zhang.stopdemo;

/**
 * 线程停止方法
 * 1.建议线程自己停止，循环次数
 * 2.使用外部标志
 * 3.不建议使用废弃的stop或者destroy
 */
public class ThreadStop1 implements Runnable{

    public boolean flag = true;
    @Override
    public void run() {
        int i =0;

        while (flag){
            System.out.println("run-->"+i++);
        }
    }

    public void stop(){
        this.flag = false;
    }
    public static void main(String[] args) {
        ThreadStop1 threadStop1 = new ThreadStop1();
        new Thread(threadStop1).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main->"+i);
            if(i == 900){
                threadStop1.stop();
                System.out.println("线程该停止");
            }
        }
    }
}
