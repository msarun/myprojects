package com.home.spring.aop.xmlbased;

import com.home.spring.aop.Circle;
import org.aspectj.lang.JoinPoint;

/**
 * Created by Arun on 11/12/2015.
 */
public class XmlAspect {

    public void allGetters() {}

    public void beforeUsingPointCut(JoinPoint joinPoint) {
        System.out.println("Calling Before using XMLPointCut: " + joinPoint.toString());
    }

    public void afterUsingPointCut(JoinPoint joinPoint) {
        System.out.println("Calling After using XMLPointCut: " + joinPoint.toString());
    }

    public void afterReturningDemo(Circle circleObj) {
        System.out.println("Calling After Returning Demo using XMLAopConfig: " + circleObj);
    }

    public void afterThrowingDemo(Exception ex) {
        System.out.println("Exception was thrown: " + ex.getMessage());
    }
}
