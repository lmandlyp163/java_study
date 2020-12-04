package com.lm.java.study.mutilthread.s02_reentrantLock.多生成多消费;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lm
 * @version 1.0
 * @desc Comsumer
 * @created 2020/12/2 上午11:22
 **/
public class Comsumer {
    public Comsumer(List<Integer> list, ReentrantLock lock, Condition producerCondition, Condition comsumerCondition) {
        this.list = list;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.comsumerCondition = comsumerCondition;
    }
    private List<Integer> list;
    private ReentrantLock lock;
    private Condition producerCondition;
    private Condition comsumerCondition;

    public void comsume(){
        while (true){
            try {
                lock.lock();
                if (CollectionUtils.isEmpty(list)){
                    comsumerCondition.await();
                } else {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()){
                        System.out.println(Thread.currentThread().getName()+ ":消费者消费"+iterator.next());
                        iterator.remove();
                    }
                    Thread.sleep(1000);
                    producerCondition.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}