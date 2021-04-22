package com.lm.java.share.thread.DCL;

/**
 * @author lm
 **/
public class T01 {
    private static T01 singleton;
    private T01() { }
    public static T01 getInstance() {
        // 多个线程同时执行到此，会生成多个Singleton实例
        if (singleton == null) {
            singleton = new T01();
        }
        return singleton;
    }
}