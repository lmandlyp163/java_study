package com.lm.java.study.mutilthread.s03_juc.c01_semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * @author lm
 * @version 1.0
 * @desc 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用。那么我们就可以通过Semaphore来实现：
 * @created 2020/12/4 下午4:48
 **/
public class SemaphoreTest {

    public static void main(String[] args){

        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");

        final Semaphore semaphore = new Semaphore(1);

        for(int i = 0;i<8;i++){
            // 定义8个线程
            new Thread("工人"+i){
                @Override
                public void run() {

                    try {
                        semaphore.acquire();
                        System.out.println(sdf.format(new Date()) + "   " + Thread.currentThread().getName() +"获得一个许可，并开始执行任务");
                        Thread.sleep(3000);
                        System.out.println(sdf.format(new Date()) + "   " + Thread.currentThread().getName() +"执行完毕，开始释放许可");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}