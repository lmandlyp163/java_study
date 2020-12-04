package com.lm.java.study.mutilthread.s02_reentrantLock.多生成多消费;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lm
 * @version 1.0
 * @desc Producer
 * @created 2020/12/2 上午11:22
 **/
public class Producer {
    public Producer(List<Integer> list, ReentrantLock lock, Condition producerCondition, Condition comsumerCondition) {
        this.list = list;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.comsumerCondition = comsumerCondition;
    }
    private List<Integer> list;
    private ReentrantLock lock;
    private Condition producerCondition;
    private Condition comsumerCondition;

    public void produce(){
        while (true){
            try {
                lock.lock();
                if (CollectionUtils.isNotEmpty(list)){//数据不需要生产
                    producerCondition.await();
                } else {// 需要生产
                    int total = 10;
                    for (int i = 1 ; i <= total ; i++){
                        list.add(i);
                        System.out.println(Thread.currentThread().getName()+"：生产者生产"+i);
                    }
                    Thread.sleep(1000);
                    comsumerCondition.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}