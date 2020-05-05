package com.zhang.syncdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * list不安全集合
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
