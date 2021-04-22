package com.lm.java.share.thread.thread;

/**
 * @author lm
 * @version 1.0
 * @desc T02_runable
 * @created 2021/4/21 下午7:09
 **/
public class T02_runable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+" run()");
        }
    }
    public static void main(String args[]){
        T02_runable t2 = new T02_runable();
        Thread t = new Thread(t2);
        t.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+" main()");
        }
    }
}