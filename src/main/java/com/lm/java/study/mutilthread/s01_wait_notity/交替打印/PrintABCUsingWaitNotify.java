package com.lm.java.study.mutilthread.s01_wait_notity.交替打印;

/**
 * @author lm
 * @version 1.0
 * @desc PrintABCUsingWaitNotify
 * A 执行后，唤醒 B，B 执行后唤醒 C，C 执行后再唤醒 A，这样循环的等待
 * @created 2020/12/1 下午10:35
 **/
public class PrintABCUsingWaitNotify {
    private int times = 10;
    private int states;
    public void print(String name, int curStates, int nThread) {
        for (int i = 0; i < times; i++) {
            try {
                synchronized (this) {
                    while (states % nThread != curStates){
                        this.wait();
                    }
                    states++;
                    System.out.println(name);
                    this.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABCUsingWaitNotify = new PrintABCUsingWaitNotify();
        int nThread = 5;
        for (int i = 0 ; i< nThread ;i++){
            int finalI = i;
            new Thread(()->{
                printABCUsingWaitNotify.print(String.valueOf("线程")+String.valueOf(finalI), finalI,nThread);
            },"线程"+finalI).start();
        }
    }

}