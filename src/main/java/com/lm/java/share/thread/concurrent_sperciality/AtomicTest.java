package com.lm.java.share.thread.concurrent_sperciality;

/**
 * 创建2个线程，然后分别执行1000次i++操作。目的是程序输出结果2000
 * 但是，多次执行的结果都小于2000
 * @author lm
 */
public class AtomicTest {
    public int inc = 0;

    public void increase() { inc++; }

    public static void main(String[] args) throws InterruptedException {
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

