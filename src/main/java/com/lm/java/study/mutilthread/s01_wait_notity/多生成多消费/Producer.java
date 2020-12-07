package com.lm.java.study.mutilthread.s01_wait_notity.多生成多消费;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
public class Producer {
    private List list;
    public Producer(){
    }
    public Producer(List list){
        this.list = list;
    }
    public void add()  {
        while(true){
            synchronized (list){
                try {
                    Thread.sleep(1000);
                    if (CollectionUtils.isNotEmpty(list)){
                        System.out.println(Thread.currentThread().getName()+ "->生产者wait");
                        list.wait();
                    } else {
                        int total = 3;
                        for (int i = 0 ; i< total ; i++){
                            System.out.println(Thread.currentThread().getName()+ "->生成i:"+i);
                            list.add(i);
                        }
                        System.out.println(Thread.currentThread().getName()+ "->生产者通知唤醒");
                        list.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}