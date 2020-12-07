package com.lm.java.study.mutilthread.s01_synchronized;

/**
 * @author lm
 * @version 1.0
 * @desc 修饰一个代码块（非this，而是指定对象）
 * @created 2020/12/4 下午2:40
 **/
class T03 implements Runnable {
    private static int count;
    public T03() {
        count = 0;
    }
    public synchronized void  print(){
        System.out.println(Thread.currentThread().getName()+"打印开始");
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public  void run() {
        print();
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        T03 syncThread = new T03();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}