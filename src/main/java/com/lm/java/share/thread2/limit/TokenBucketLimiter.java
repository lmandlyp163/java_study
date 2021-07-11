package com.lm.java.share.thread2.limit;

/**
 * lm
 * 令牌桶算法是对漏桶算法的一种改进，除了能够在限制调用的平均速率的同时还允许一定程度的流量突发。
 **/
public class TokenBucketLimiter {
    private int capaticy;//令牌桶容量
    private int rate;//令牌产生速率
    private int tokenAmount;//令牌数量
    public TokenBucketLimiter(int capaticy, int rate) {
        this.capaticy = capaticy;
        this.rate = rate;
        tokenAmount = capaticy;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //以恒定速率放令牌
                while (true){
                    synchronized (this){
                        tokenAmount ++;
                        if(tokenAmount > capaticy){
                            tokenAmount = capaticy;
                        }
                    }
                    try {
                        Thread.sleep(1000 / rate);
                    } catch (InterruptedException e) { }
                }
            }}).start();
    }

    public synchronized boolean tryAcquire(int i){
        if(tokenAmount > 0){
            tokenAmount --;
            System.out.println(i+"拿到令牌");
            return true;
        }else{
            return false;
        }

    }


    public static void main(String[] args)
            throws InterruptedException {
        TokenBucketLimiter tokenBucketLimiter =
                new TokenBucketLimiter(5,2);
        for(int i = 1;i <= 10;i ++){
            if(tokenBucketLimiter.tryAcquire(i)){
                System.out.println(i + "号请求被处理");
                Thread.sleep(100);
            }else{
                System.out.println(i + "号请求被拒绝");
                Thread.sleep(100);
            }
        }
    }
}
