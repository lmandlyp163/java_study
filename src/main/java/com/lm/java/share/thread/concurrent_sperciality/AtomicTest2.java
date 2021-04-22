package com.lm.java.share.thread.concurrent_sperciality;

/**
 * @author lm
 */
public class AtomicTest2 {
    public int inc = 0;

    public synchronized void increase() { inc++; }

    public static void main(String[] args) throws InterruptedException {
        final AtomicTest2 test = new AtomicTest2();
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

