package com.home.spring.aop.annotations;


import com.home.spring.aop.Circle;
import com.home.spring.aop.CircleAudit;
import com.home.spring.aop.CircleAuditImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.time.LocalDate;

/**
 * Created by Arun on 11/11/2015.
 */

@Aspect
public class AspectDemo {

    // uncomment--> Demo for @Before
    //@Before("execution(* com.home.spring.aop.Circle.get*())")
    public void beforeAdvice() {
        System.out.println("Advice Before get in Circle()");
    }

    @Pointcut("execution(* com.home.spring.aop.Circle.get*())")
    public void allGetters() {
        System.out.println("Point Cut for All getters");
    }

    @Before("allGetters()")
    public void beforeAdviceUsingPointCut() {
        System.out.println("Advice Before get using pointcut in Circle()");
    }

    @Pointcut("execution(* com.home.spring.aop.Circle.set*())")
    public void afterPointcut() {

    }

    @After("afterPointcut()")
    public void AfterAdviceUsingPointCut() {
        System.out.println("After Method using point cut");
    }

    @Pointcut("within(com.home.spring.aop.Circle)")
    public void withinAnnotation() {}

    @Before("withinAnnotation()")
    public void AdviceUsingWithin() {
        System.out.println("Demo using within");

    }

    @Pointcut("execution(String com.home.spring.aop.Circle.getName())")
    public void returnAdviceDemo() {}

    @AfterReturning(value = "returnAdviceDemo()", returning = "name")
    public void afterReturnDemo(String name) {
        System.out.println("After Returing Demo: returned " + name );
    }

    @AfterReturning(pointcut = "execution(com.home.spring.aop.Circle com.home.spring.aop.Circle.getInstance())", returning = "circleObj")
    public void afterReturnDemo_2(Circle circleObj) {
        System.out.println("After Returning Demo part 2, Returned Obj: " + circleObj);
    }

    @AfterThrowing(pointcut = "execution(void com.home.spring.aop.Circle.throwEx())", throwing = "ex")
    public void afterThrowDemo(Exception ex) {
        System.out.println("After Throw: " + ex);
    }

    @Around(value = "returnAdviceDemo()")
    public void returnDemo(ProceedingJoinPoint joinPoint) {
        System.out.println("Before Around Demo");

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("After Around Demo");
    }

    @Before(value = "execution(com.home.spring.aop.Circle com.home.spring.aop.Circle.getInstance())")
    public void jointPointDemo(JoinPoint joinPoint) {
        Circle circleObj = (Circle)joinPoint.getTarget();
        System.out.println("Before Calling Method Using JoinPoint: " + circleObj.toString());
    }

    @DeclareParents(value = "com.home.spring.aop.Circle+", defaultImpl = CircleAuditImpl.class)
    CircleAudit circleAudit;

    @After("execution(* com.home.spring.aop.Circle.set*()))")
    public void updateAuditForSetters() {
        System.out.println("Updating Circle Audit for all Setters: ");
        circleAudit.setLastModifiedDate(LocalDate.now());
    }
}
