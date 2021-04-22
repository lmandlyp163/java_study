package com.lm.java.share.thread.DCL;

/**
 * @author lm
 **/
public class T03 {
    private static T03 singleton;
    private T03() { }
    public static T03 getInstance() {
        if (singleton == null) {
            // 1 只有singleton==null时才加锁，性能好
            synchronized (T03.class) {
                if (singleton == null) {
                    singleton = new T03();
                }
            }
        }
        return singleton;
    }
}
