package com.lm.java.study.mutilthread.s03_juc.c01_semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author lm
 * @version 1.0
 * @desc StudySemaphore
 * @created 2020/12/2 下午2:20
 **/
public class StudySemaphore {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，只允许 3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<10;i++){
            final long num = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        //执行
                        System.out.println("Accessing: " + num);
                        Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                        //释放
                        semaphore.release();
                        System.out.println("Release..." + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

}