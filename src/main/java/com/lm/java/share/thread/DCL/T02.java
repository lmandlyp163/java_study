package com.lm.java.share.thread.DCL;

/**
 * @author lm
 **/
public class T02 {
    private static T02 singleton;
    private T02() { }
    public static synchronized T02 getInstance() {
        if (singleton == null) {
            singleton = new T02();
        }
        return singleton;
    }
}