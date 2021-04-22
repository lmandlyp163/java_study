package com.lm.java.share.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lm
 */
public class AtomicTest {
    private AtomicInteger inc = new AtomicInteger(0);

    public void increase() { inc.getAndIncrement(); }

    public static void main(String[] args) throws Exception {
        final AtomicTest test = new AtomicTest();
        Thread threadA = new Thread(() -> {
            for (long i = 0; i < 1000; i++)
            { test.increase(); }
        }, "ThreadA");
        Thread threadB = new Thread(() -> {
            for (long i = 0; i < 1000; i++)
            { test.increase(); }
        }, "ThreadB");
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(test.inc);
    }
}

