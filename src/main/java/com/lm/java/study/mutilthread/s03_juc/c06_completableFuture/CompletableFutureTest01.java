package com.lm.java.study.mutilthread.s03_juc.c06_completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author lm
 * @version 1.0
 * @desc CompletableFutureTest01
 * @created 2020/12/5 下午4:31
 **/
class CompletableFutureTest01{
    public CompletableFuture<String> findUser(){
        CompletableFuture<String> future = new CompletableFuture();
        //模仿远程调用线程
        new Thread(){
            @Override
            public void run() {
                String result = null;
                System.out.println("任务开始执行....");
                try{
                    Thread.sleep(3000);
                    //模仿RPC远程调用
                    result = rpcRequest(true);
                    System.out.println("任务执行结束....");
                }
                catch(Exception ex){
                    future.completeExceptionally(ex);
                }
                future.complete(result);
            }
        }.start();
        //直接返回future.
        return future;
    }

    /**
     * @Description   模仿RPC远程调用
     */
    public String rpcRequest(boolean flag){
        String result = null;
        if(flag){
            result = "libai";
        }
        else {
            throw new NullPointerException();
        }
        return  result;
    }

    public static void main(String args[]){
        CompletableFutureTest01 service = new CompletableFutureTest01();
        CompletableFuture<String> future = service.findUser();
        // 主线程通过whenComplete来回调结果
        future.whenComplete((t,u)->{
            if(u != null){
                System.out.println("异步调用发生异常:" + u);
            }
            else {
                System.out.println("异步调用执行正常: " + t);
            }
        });
        System.out.println("主线程任务执行完毕");

    }

}