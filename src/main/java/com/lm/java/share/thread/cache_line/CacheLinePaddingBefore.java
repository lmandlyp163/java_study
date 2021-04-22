package com.lm.java.share.thread.cache_line;

/**
 * @author lm
 **/
public class CacheLinePaddingBefore {
    public volatile long x = 1L;
    public volatile long y = 1L;
    public static void main(String[] args) throws Exception {
        CacheLinePaddingBefore cacheLinePaddingBefore =
                new CacheLinePaddingBefore();
        Thread threadA = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++)
            { cacheLinePaddingBefore.x = i; }
        }, "ThreadA");
        Thread threadB = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++)
            { cacheLinePaddingBefore.y = i; }
        }, "ThreadB");
        final long start = System.nanoTime();
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        final long end = System.nanoTime();
        System.out.println("耗时：" + (end - start) / 100_0000);
    }
}