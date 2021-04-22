package com.lm.java.study.javabase.s02_aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lm
 * @version 1.0
 * @desc AnnoAspect
 * @created 2020/12/8 下午3:08
 **/
@Aspect
public class AnnoAspect {
    @Pointcut("execution(* com.lm.java.study.javabase.s02_aspectj.App.say(..))")
    public void jointPoint() {
    }

    @Before("jointPoint()")
    public void before() {
        System.out.println("AnnoAspect before say");
    }

    @After("jointPoint()")
    public void after() {
        System.out.println("AnnoAspect after say");
    }
}