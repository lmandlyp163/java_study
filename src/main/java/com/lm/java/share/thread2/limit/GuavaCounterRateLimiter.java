package com.lm.java.share.thread2.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author lm
 * @created 2021/7/7 下午3:12
 **/
public class GuavaCounterRateLimiter {


    public static void main(String[] args) {
        //创建一个RateLimiter，指定每秒放0.5个令牌（2秒放1个令牌）
        RateLimiter rateLimiter = RateLimiter.create(0.5);
        int[] a = {1,6,2};
        for(int i = 0; i < a.length; ++i) {
            //acquire(x)  从RateLimiter获取x个令牌，该方法会被阻塞直到获取到请求
            System.out.println(System.currentTimeMillis() + " acq " + a[i] + ": wait " + rateLimiter.acquire(a[i]) + "s");
        }

    }
}
