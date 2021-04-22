package com.lm.java.share.thread.synchronized_test;


/**
 * @author lm
 * @version 1.0
 * @desc 修饰一个代码块
 **/
class T01 implements Runnable {
    private static int count;

    public T01() {
        count = 0;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "测试");
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName()
                        + ":" + (count++));
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        T01 syncThread1 = new T01();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread1, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}