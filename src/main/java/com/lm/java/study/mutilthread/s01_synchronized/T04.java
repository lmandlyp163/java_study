package com.lm.java.study.mutilthread.s01_synchronized;

/**
 * @author lm
 * @version 1.0
 * @desc synchronized修饰静态方法）
 * @created 2020/12/4 下午2:40
 **/
class T04 implements Runnable {
    private static int count;
    public T04() {
        count = 0;
    }
    public synchronized static void  print(){
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
        T04 syncThread1 = new T04();
        T04 syncThread2 = new T04();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}