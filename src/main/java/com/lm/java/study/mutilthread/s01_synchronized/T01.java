package com.lm.java.study.mutilthread.s01_synchronized;

/**
 * @author lm
 * @version 1.0
 * @desc synchronized修饰的方法使用
 * @created 2020/12/4 下午2:40
 **/
class T01 implements Runnable {
    private static int count;
    public T01() {
        count = 0;
    }
    public  void run() {
        synchronized(this) {
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
        T01 syncThread = new T01();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}