package com.lm.java.study.mutilthread.s00_base.c01_JMM.缓存行;

/**
 * @author lm
 * @version 1.0
 * @desc CacheLinePaddingAfter
 * @created 2020/12/3 下午3:05
 **/
public class CacheLinePaddingAfter {
    private static class Entity {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
        public volatile long x = 1L;
        public volatile long p11, p12, p13, p14, p51, p16, p17;
    }

    public static CacheLinePaddingAfter.Entity[] arr = new CacheLinePaddingAfter.Entity[2];
    static {
        arr[0] = new CacheLinePaddingAfter.Entity();
        arr[1] = new CacheLinePaddingAfter.Entity();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) { arr[0].x = i; }
        }, "ThreadA");
        Thread threadB = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) { arr[1].x = i; }
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