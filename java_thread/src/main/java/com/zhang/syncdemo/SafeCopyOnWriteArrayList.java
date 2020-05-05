package com.zhang.syncdemo;

import java.util.concurrent.CopyOnWriteArrayList;
//JUC编程  java.util.concurrent(简称JUC)包,在此包中增加了在并发编程中很常用的工具类,
public class SafeCopyOnWriteArrayList {
    public static void main(String[] args) throws InterruptedException {
        //concurrent 并发包下的
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }

}
