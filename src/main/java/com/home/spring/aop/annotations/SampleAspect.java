package com.home.spring.aop.annotations;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Arun on 11/9/2015.
 */

@Aspect
public class SampleAspect {

    @Before("execution( * aop.Circle.getRadius())")
    public void log() {
        System.out.println("Before Calling Get");
    }

    //@After("execution(* AOP.Circle.getRadius())")
    @After("execution(pc)")
    public void afterMethodInvocationLog() {
        System.out.println("Called After Method get");
    }

    @Pointcut("execution(* aop.Circle.getRadius())")
    public void pc() {}

}
