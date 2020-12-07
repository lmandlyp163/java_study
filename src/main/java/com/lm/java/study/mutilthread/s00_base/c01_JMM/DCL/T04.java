package com.lm.java.study.mutilthread.s00_base.c01_JMM.DCL;

/**
 * @author lm
 * @version 1.0
 * @desc T01
 * @created 2020/12/4 下午1:16
 **/


public class T04 {

    private volatile static T04 singleton;// 通过volatile关键字来确保安全
    Integer a;

    private T04() {
    }

    public static T04 getInstance() {
        if (singleton == null) {               // 1 只有singleton==null时才加锁，性能好
            synchronized (T04.class) {         // 2
                if (singleton == null) {       // 3
                    singleton = new T04();     // 4
                }
            }
        }
        return singleton;
    }

}
