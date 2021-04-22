package com.lm.java.share.thread.thread;

import java.util.Random;

/**
 * @author lm
 * 患者先去挂号，然后到就诊门口分诊，等待叫号；
 * 当叫到自己的号时，患者就可以找大夫就诊了；
 * 就诊过程中，大夫可能会让患者去做检查，同时叫下一位患者；
 * 当患者做完检查后，拿检测报告重新分诊，等待叫号；
 * 当大夫再次叫到自己的号时，患者再去找大夫就诊。
 **/
public class T03_wait_notify {
    private int states;

    public void print(String name, int curStates, int nThread) throws InterruptedException {
        int times = 1;
        Random random = new Random();
        while (true) {
            synchronized (this) {
                while (states % nThread != curStates) {
                    this.wait();
                }
                states = random.nextInt(5);
                if (times == 1) {// 看病
                    System.out.println(name + "看病");
                }
                if (times == 2) {// 检查
                    System.out.println(name + "检查");
                }
                if (times == 3) {// 复查
                    System.out.println(name + "复查");
                }
                times++;
                this.notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        T03_wait_notify t03_wait_notify = new T03_wait_notify();
        int nThread = 5;
        for (int i = 0; i < nThread; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    t03_wait_notify.print(String.valueOf("病人") +
                            String.valueOf(finalI), finalI, nThread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "病人" + finalI).start();
        }
    }

}