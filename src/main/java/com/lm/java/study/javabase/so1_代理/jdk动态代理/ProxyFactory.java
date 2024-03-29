package com.lm.java.study.javabase.so1_代理.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lm
 * @version 1.0
 * @desc ProxyFactory
 * @created 2020/12/8 上午11:01
 **/
public class ProxyFactory {
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理前");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("代理后");
                        return returnValue;
                    }
                }
        );
    }
}