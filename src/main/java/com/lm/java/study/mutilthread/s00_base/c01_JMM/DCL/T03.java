package com.lm.java.study.mutilthread.s00_base.c01_JMM.DCL;

/**
 * @author lm
 * @version 1.0
 * @desc T01
 * @created 2020/12/4 下午1:16
 **/


public class T03 {

    private static T03 singleton;
    Integer a;

    private T03() {
    }

    public static T03 getInstance() {
        if (singleton == null) {               // 1 只有singleton==null时才加锁，性能好
            synchronized (T03.class) {         // 2
                if (singleton == null) {       // 3
                    singleton = new T03();     // 4
                }
            }
        }
        return singleton;
    }

}
