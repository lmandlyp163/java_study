package com.lm.java.study.javabase.so1_代理.jdk动态代理;

/**
 * @author lm
 * @version 1.0
 * @desc AdminServiceImpl
 * @created 2020/12/8 上午10:48
 **/
public class AdminServiceImpl implements AdminService {
    public void update() {
        System.out.println("修改管理系统数据");
    }

    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}
