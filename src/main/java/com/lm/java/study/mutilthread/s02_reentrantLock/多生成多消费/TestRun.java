package com.lm.java.study.mutilthread.s02_reentrantLock.多生成多消费;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lm
 * @version 1.0
 * @desc TestRun
 * @created 2020/12/2 上午11:22
 **/
public class TestRun {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        ReentrantLock lock = new ReentrantLock(false);
        Condition producerCondition = lock.newCondition();
        Condition comsumerCondition = lock.newCondition();
        Producer producer = new Producer(list,lock,producerCondition,comsumerCondition);
        Comsumer comsumer = new Comsumer(list,lock,producerCondition,comsumerCondition);
        for (int i= 1; i <=2 ;i++){
            new Thread(()->{
                producer.produce();
            },"生产线程"+i).start();

            new Thread(()->{
                comsumer.comsume();
            },"消费线程"+i).start();
        }
        System.out.println();
    }
}