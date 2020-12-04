package com.lm.java.study.mutilthread.s03_juc.c05_phaser;

import java.util.concurrent.Phaser;

/**
 * @author lm
 * @version 1.0
 * @desc PhaserTest
 * @created 2020/12/2 下午3:32
 **/
public class PhaserTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("=======phase: " + phase + " finished=============");
                return super.onAdvance(phase, registeredParties);
            }
        };

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(String.format("%s: phase: %d", Thread.currentThread().getName(), finalI));
                phaser.arriveAndAwaitAdvance();
            }, "Thread " + i).start();
            if (i == 2){
                phaser.register();
            }
        }
    }
}