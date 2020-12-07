package com.lm.java.study.mutilthread.s00_base.c01_JMM.DCL;

/**
 * @author lm
 * @version 1.0
 * @desc T01
 * @created 2020/12/4 下午1:16
 **/

public class T02 {

    private static T02 singleton;

    private T02() {
    }

    public static synchronized  T02 getInstance() {
        if (singleton == null) {
            singleton = new T02();
        }
        return singleton;

    }

}