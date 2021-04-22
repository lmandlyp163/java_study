package com.lm.java.share.thread.cache_line;

/**
 * @author lm
 **/
public class CacheLinePaddingAfter {
    public volatile long p1, p2, p3, p4, p5, p6, p7;
    public volatile long x = 1L;
    public volatile long p11, p12, p13, p14, p51, p16, p17;
    public volatile long y = 1L;
    public static void main(String[] args) throws Exception {
        CacheLinePaddingAfter cacheLinePaddingAfter
                = new CacheLinePaddingAfter();
        Thread threadA = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++)
            { cacheLinePaddingAfter.x = i; }
        }, "ThreadA");
        Thread threadB = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++)
            { cacheLinePaddingAfter.y = i; }
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