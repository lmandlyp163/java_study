package com.lm.java.study.mutilthread.s00_base.c01_JMM.DCL;

/**
 * @author lm
 * @version 1.0
 * @desc T01
 * @created 2020/12/4 下午1:16
 **/

public class T01 {

    private static T01 singleton;

    private T01() {
    }

    public static T01 getInstance() {
        if (singleton == null) {// 多个线程同时执行到此，会生成多个Singleton实例
            singleton = new T01();
        }
        return singleton;

    }

}