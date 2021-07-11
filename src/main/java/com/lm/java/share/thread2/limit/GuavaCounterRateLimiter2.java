package com.lm.java.share.thread2.limit;



import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author lm
 * @created 2021/7/7 下午3:12
 **/
public class GuavaCounterRateLimiter2 {


    public static void main(String[] args) throws InterruptedException {
        //预热模式,设置预热时间和QPS，即在正式acquire前，限流器已经持有5*4=20个令牌
        RateLimiter rateLimiter = RateLimiter
                .create(5, 4000, TimeUnit.MILLISECONDS);
        for(int i = 1; i < 50; i++) {
            System.out.println(System.currentTimeMillis()
                    + " acq " + i + ": wait " + rateLimiter.acquire() + "s");
            if(i == 15) {
                Thread.sleep(2000);
                System.out.println(System.currentTimeMillis()
                        + " acq " + 15 + ": wait " + rateLimiter.acquire() + "s");
            }
        }
    }
}
