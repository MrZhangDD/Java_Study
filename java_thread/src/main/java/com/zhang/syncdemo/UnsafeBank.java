package com.zhang.syncdemo;

import javax.sound.midi.Soundbank;

/**
 * 模拟银行取钱，不安全线程
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"教育");
        Drawing drawing = new Drawing(account, 50, "你");
        Drawing drawing2 = new Drawing(account, 100, "她");
        drawing.start();
        drawing2.start();
    }
}

class Account{
    int money; //钱数
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread{
    Account account; //银行账户
    int drawingMoeny;//取的钱数
    int nowMoney;//手里有的钱数
    public Drawing(Account account,int drawingMoeny,String name){
        super(name);
        this.account = account;
        this.drawingMoeny = drawingMoeny;
    }

    //取钱过程
    @Override
    public void run() {
        //锁的对象是变化的量
        synchronized (account){
            if(account.money < drawingMoeny){
                System.out.println("卡内余额不足");
                return;
            }
            //sleep可以放大问题的发生性
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额减少
            account.money = account.money - drawingMoeny;
            //手中的钱增加
            nowMoney = nowMoney + drawingMoeny;
            System.out.println(account.name+"-卡内余额："+account.money);
            System.out.println(this.getName()+"手里："+nowMoney);
        }

    }
}

