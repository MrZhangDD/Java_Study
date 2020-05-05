package com.zhang.stopdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleep1 {
    public static void turnDonw() throws InterruptedException {
        int num = 10;
        while (true){
          Thread.sleep(1000);
          System.out.println("num-->"+num--);
          if(num <=0){
              break;
          }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //turnDonw();
        //模拟系统时间
        Date date = new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date = new Date(System.currentTimeMillis());
        }
    }
}
