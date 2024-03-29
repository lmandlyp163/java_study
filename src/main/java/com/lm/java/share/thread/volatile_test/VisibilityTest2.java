package com.lm.java.share.thread.volatile_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lm
 * 根据之前的不可见的case加上关键字volatile之后可见了
 **/
public class VisibilityTest2 {
    public volatile  static  boolean a = true;
    public static void main(String[] args) throws Exception {
        System.out.println("我开始了");
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        //线程开始
        executorService.execute(() -> {
            while(a){

            }
            System.out.println("我退出了");
        });
        Thread.sleep(100);
        a = false;
    }
}