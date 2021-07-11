package com.lm.java.share.thread.concurrent_sperciality;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 结果：明明将flag设置为true了 为什么没有看见我退出了。
 * @author lm
 **/
public class VisibilityTest {
    public static  boolean a = true;
    public static void main(String[] args) throws Exception {
        System.out.println("我开始了");
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        //线程开始
        executorService.execute(() -> {
            Integer i= 1;
            while(a){
                synchronized (i){
                    i++;
                }
            }
            System.out.println("我退出了");
        });
        a = false;
        System.out.println(a);
    }
}