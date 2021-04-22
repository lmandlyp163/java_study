package com.lm.java.study.javabase.so1_代理.cglib代理;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lm
 * @version 1.0
 * @desc Test
 * @created 2020/12/8 上午11:31
 **/
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete hello = (HelloConcrete)enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}