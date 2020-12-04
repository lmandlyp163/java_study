package com.lm.java.study.mutilthread.s01_wait_notity.单生产单消费;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @author lm
 * @version 1.0
 * @desc Comsumer
 * @created 2020/12/1 下午4:58
 **/
public class Comsumer {

    private List list;

    public Comsumer(){
    }

    public Comsumer(List list){
        this.list = list;
    }

    public void remove()  {
        while(true){
            synchronized (list){
                try {
                    Thread.sleep(1000);
                    if (CollectionUtils.isNotEmpty(list)){
                        Iterator iterator = list.iterator();
                        while (iterator.hasNext()){
                            System.out.println(Thread.currentThread().getName()+ "->消费i"+iterator.next());
                            iterator.remove();
                        }
                        System.out.println(Thread.currentThread().getName()+ "->消费者通知唤醒");
                        list.notify();
                    } else {
                        System.out.println(Thread.currentThread().getName()+ "->消费者wait");
                        list.wait();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}