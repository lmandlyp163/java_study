package com.lm.java.study.jvm.运行时内存区域.字符串常量池;

/**
 * @author lm
 * @version 1.0
 * @desc test1
 * @created 2020/12/29 下午3:17
 **/
public class test1 {

    public static void main(String[] args) {
        String a1 = "Hello" + "world";
        String a2 = "Helloworld";
        String a3 = "Hello";
        String a4 = "world";
        String a5 = a3+a4;
        String a6 = new String("Hello")+new String("world");
        String a7 = a6.intern();
        System.out.println(a1==a2);//true
        System.out.println(a2==a5);//false
        System.out.println(a5==a6);//false
        System.out.println(a5==a7);//false
        System.out.println(a2==a7);//false
    }
}