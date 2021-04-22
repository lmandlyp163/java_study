package com.lm.java.study.javabase.so1_代理.静态代理;

/**
 * @author lm
 * @version 1.0
 * @desc StaticProxyTest
 * @created 2020/12/8 上午10:48
 **/
public class StaticProxyTest {

    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminServiceProxy proxy = new AdminServiceProxy(adminService);
        proxy.update();
        System.out.println("=============================");
        proxy.find();
    }
}