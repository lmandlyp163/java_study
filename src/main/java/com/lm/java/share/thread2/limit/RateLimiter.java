// Copyright (C) 2021 Meituan
// All rights reserved
package com.lm.java.share.thread2.limit;

/**
 * @author lm
 * @version 1.0
 * RateLimiter是一个通用的接口
 * @created 2021/7/7 下午4:01
 **/
public interface RateLimiter {
    boolean isOverLimit();

    int currentQPS();

    boolean visit();
}