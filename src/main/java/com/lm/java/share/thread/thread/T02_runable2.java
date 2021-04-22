package com.lm.java.share.thread.thread;

/**
 * @author lm
 * @version 1.0
 * @desc T02_runable2
 * @created 2021/4/21 下午7:11
 **/
public class T02_runable2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名类执行");
            }
        }));
        thread1.start();

        Thread thread2 = new Thread((()-> {
            System.out.println("函数式执行");
        }));
        thread2.start();

    }
}