package com.lm.java.share.thread.synchronized_test;


/**
 * @author lm
 * @version 1.0
 * @desc 测试非同对象实例的场景
 **/
class T02_badcase implements Runnable {
    private static int count;

    public T02_badcase() {
        count = 0;
    }

    public synchronized void print() {
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
        T02 syncThread1 = new T02();
        T02 syncThread2 = new T02();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}