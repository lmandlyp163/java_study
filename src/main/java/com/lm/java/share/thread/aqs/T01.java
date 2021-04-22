package com.lm.java.share.thread.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lm
 * @version 1.0
 * @desc T01
 * @created 2021/4/16 下午2:53
 **/
public class T01 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        ReentrantLock lock = new ReentrantLock();
        for (int i = 1 ; i <=2 ; i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "测试start");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "测试end");
                }
            });
        }

    }

}