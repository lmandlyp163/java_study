package com.lm.java.study.mutilthread.s03_juc.c05_phaser;

import java.util.concurrent.Phaser;

/**
 * @author lm
 * @version 1.0
 * @desc Match
 * @created 2020/12/2 下午3:49
 **/
public class Player implements Runnable {
    private final Phaser phaser ;
    Player(Phaser phaser){
        this.phaser=phaser;
    }
    @Override
    public void run() {
        try {
            // 第一阶段——等待创建好所有线程再开始
            System.out.println(Thread.currentThread().getName() + " 第一阶段准备");
            phaser.arriveAndAwaitAdvance();

            // 第二阶段——等待所有选手准备好再开始
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " 第二阶段准备");
            phaser.arriveAndAwaitAdvance();

            // 第三阶段——等待所有选手准备好到达，到达后，该线程从phaser中注销，不在进行下面的阶段。
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " arrived");
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // 模拟了100米赛跑，10名选手，只等裁判一声令下。当所有人都到达终点时，比赛结束。
    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser=new Phaser() ;
        for (int index = 0; index < 10; index++) {// 十名选手
            phaser.register();
            new Thread(new Player(phaser),"player"+index).start();
        }
        Thread.sleep(2000);
        System.out.println(phaser.getRegisteredParties());
        //注销当前线程,比赛开始
        phaser.arriveAndDeregister();
        //是否非终止态一直等待
        while(!phaser.isTerminated()){ }
        System.out.println("Game Over");
    }
}