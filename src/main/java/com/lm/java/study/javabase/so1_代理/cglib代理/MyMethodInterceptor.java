package com.lm.java.study.javabase.so1_代理.cglib代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lm
 * @version 1.0
 * @desc MyMethodInterceptor
 * @created 2020/12/8 上午11:28
 **/
public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("You said: " + Arrays.toString(args));
        return proxy.invokeSuper(obj, args);
    }
}