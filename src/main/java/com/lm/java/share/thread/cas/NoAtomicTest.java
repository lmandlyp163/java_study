package com.lm.java.share.thread.cas;

/**
 * @author lm
 */
public class NoAtomicTest {
    public volatile  int inc = 0;

    public void increase() { inc++; }

    public static void main(String[] args) throws Exception {
        final NoAtomicTest test = new NoAtomicTest();
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

