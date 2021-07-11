package com.lm.java.share.thread2.limit;

import java.util.LinkedList;

public class LeakyBucketLimiter {
    private int capaticy;//漏斗容量
    private int rate;//漏斗速率
    private LinkedList<Integer> requestList;
    public LeakyBucketLimiter(int capaticy, int rate) {
        this.capaticy = capaticy;this.rate = rate;
        requestList = new LinkedList<>();
        //开启一个定时线程，以固定的速率将漏斗中的请求流出，进行处理
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(!requestList.isEmpty()){
                        System.out.println("流出："+requestList.removeFirst());
                    }
                    try {//大约每500ms处理一个
                        Thread.sleep(1000 / rate);
                    } catch (InterruptedException e) { }
                }
            }}).start();
    }
    public synchronized boolean tryAcquire(Integer i){
        if(capaticy - requestList.size()  <= 0){
            return false;
        }else{
            requestList.addLast(i);
            return true;
        }
    }
    public static void main(String[] args)
            throws InterruptedException {
        LeakyBucketLimiter leakyBucketLimiter
                = new LeakyBucketLimiter(5,2);
        for(int i = 1;i <= 10;i ++){
            if(leakyBucketLimiter.tryAcquire(i)){
                System.out.println(i + "号请求被接受");
                Thread.sleep(100);
            }else{
                System.out.println(i + "号请求被拒绝");
                Thread.sleep(100);
            }
        }
    }
}
