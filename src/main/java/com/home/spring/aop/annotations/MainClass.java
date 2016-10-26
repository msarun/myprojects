package com.home.spring.aop.annotations;

import com.home.spring.aop.Circle;
import com.home.spring.aop.CircleAudit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Arun on 11/9/2015.
 */
public class MainClass {
    public static void main(String[] args)  {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.getBean("circle");
      /*  Circle circle = (Circle)context.getBean("circle");
        System.out.println(circle.getRadius());
        System.out.println(circle.getName());
        circle.setName("C1");
        circle.getInstance();
        try {
            circle.throwEx();
        } catch (Exception e) {
            //e.printStackTrace();
        }*/
        System.out.println(((CircleAudit)context.getBean("circle")).getLastModifiedDate());
    }
}
