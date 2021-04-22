package com.lm.java.share.thread.DCL;

/**
 * @author lm
 **/
public class T04 {
    // 通过volatile关键字来确保安全
    private volatile static T04 singleton;
    private T04() { }
    public static T04 getInstance() {
        if (singleton == null) {
            // 只有singleton==null时才加锁，性能好
            synchronized (T04.class) {
                if (singleton == null) {
                    singleton = new T04();
                }
            }
        }
        return singleton;
    }
}
