package com.lm.java.study.mutilthread.s01_synchronized;

/**
 * @author lm
 * @version 1.0
 * @desc 修饰一个代码块（非this，而是指定对象）
 * @created 2020/12/4 下午2:40
 **/
class T02 implements Runnable {
    private static int count;
    private Object object;
    public T02(Object object) {
        count = 0;
        object =object;
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
        Object o = new Object();
        T02 syncThread = new T02(o);
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}