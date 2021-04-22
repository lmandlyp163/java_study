package com.lm.java.share.thread.synchronized_test;


/**
 * @author lm
 * @version 1.0
 * @desc 修饰一个类
 **/
class T04 implements Runnable {
    private static int count;

    public T04() {
        count = 0;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "测试");
        for (int i = 0; i < 5; i++) {
            synchronized (T04.class) {
                System.out.println(Thread.currentThread().getName()
                        + ":" + (count++));
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        T04 syncThread1 = new T04();
        T04 syncThread2 = new T04();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}