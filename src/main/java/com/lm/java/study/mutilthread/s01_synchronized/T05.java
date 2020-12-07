package com.lm.java.study.mutilthread.s01_synchronized;

/**
 * @author lm
 * @version 1.0
 * @desc synchronized修饰类
 * @created 2020/12/4 下午2:40
 **/
class T05 implements Runnable {
    private static int count;
    public T05() {
        count = 0;
    }
    public  void run() {
        synchronized(T05.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        T05 syncThread1 = new T05();
        T05 syncThread2 = new T05();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}