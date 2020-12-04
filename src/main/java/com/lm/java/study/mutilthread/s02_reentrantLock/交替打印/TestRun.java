package com.lm.java.study.mutilthread.s02_reentrantLock.交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lm
 * @version 1.0
 * @desc TestRun
 * @created 2020/12/2 上午11:42
 **/
public class TestRun {
    private int times = 10;
    private int state;
    public void print(int curState, int nThread, ReentrantLock lock, Condition condition, String name) {
        for (int i = 1; i <= times; i++) {
            try {
                lock.lock();
                while (state % nThread != curState) {
                    condition.await();
                }
                state++;
                System.out.print(name);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        TestRun testRun = new TestRun();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int nThread = 5;
        for (int i = 0 ; i< nThread ;i++){
            int finalI = i;
            new Thread(()->{
                testRun.print(finalI,nThread,lock,condition,String.valueOf(finalI));
            }).start();
        }
    }


}