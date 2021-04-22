package com.lm.java.share.thread.synchronized_test;


/**
 * @author lm
 * @version 1.0
 * @desc 修饰一个类-badcase
 **/
class T04_badcase implements Runnable {
    private static int count;

    public T04_badcase() {
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
        T04_badcase syncThread1 = new T04_badcase();
        T04_badcase syncThread2 = new T04_badcase();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}