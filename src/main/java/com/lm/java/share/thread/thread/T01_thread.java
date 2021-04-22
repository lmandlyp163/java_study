package com.lm.java.share.thread.thread;

/**
 * @author lm
 **/
public class T01_thread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+" run1()");
        }
    }
    public static void main(String args[]){
        T01_thread t1 = new T01_thread();
        t1.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+" main1()");
        }
    }
}