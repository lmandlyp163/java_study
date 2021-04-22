package com.lm.java.share.thread.synchronized_test;


/**
 * @author lm
 * @desc 修饰一个静态方法
 **/
class T03 implements Runnable {
    private static int count;

    public T03() {
        count = 0;
    }

    public static synchronized void print() {
        System.out.println(Thread.currentThread().getName() + "测试");
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + ":" + (count++));
        }
    }

    public void run() { print(); }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        T03 syncThread1 = new T03();
        T03 syncThread2 = new T03();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}