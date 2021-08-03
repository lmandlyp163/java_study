package com.lm.java.study.mutilthread.s03_juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lm
 * @version 1.0
 * @desc ExecutorCompletionServiceTest
 * @created 2021/8/2 下午8:06
 **/
public class ExecutorCompletionServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
        Callable<String> callableTask = () -> {
            Random random = new Random();
            TimeUnit.MILLISECONDS.sleep(300*random.nextInt(10));
            return Thread.currentThread().getName()+"Task's execution";
        };
        for (int i = 0; i < 5; i++) {
            completionService.submit(callableTask);
        }

        for (int i = 0; i < 5; i++) {
            Future<String> result = completionService.take();
            System.out.println(result.get());
        }
    }
}