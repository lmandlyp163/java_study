package com.lm.java.study;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
            if (i == 20) {
                // 实质还是以Callable对象来创建、并启动线程
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            // 获取线程返回值
            System.out.println("子线程的返回值：" + task.get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
