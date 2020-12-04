package com.lm.java.study.mutilthread.s03_juc.c03_countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lm
 * @version 1.0
 * @desc CountDownLatchTest
 * @created 2020/12/2 下午2:50
 **/
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行…… ……");
        //第一个子线程执行
        ExecutorService es1 = Executors.newCachedThreadPool();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        //第二个子线程执行
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                latch.countDown();
            }
        });
        System.out.println("等待两个线程执行完毕…… ……");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
        es1.shutdown();
    }
}