package com.home.spring.aop.xmlbased;

import com.home.spring.aop.Circle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Arun on 11/12/2015.
 */
public class XmlDemoMainClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Circle circle = (Circle) applicationContext.getBean("circle");
        circle.getName();
        circle.getRadius();
        circle.getInstance();
        try {
            circle.throwEx();
        } catch (Exception e) {
           // e.printStackTrace();
        }

    }
}
