package com.home.spring.core;

import com.home.spring.core.domain.TextEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

/**
 * Created by Arun on 11/23/2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TextEditor te = (TextEditor) context.getBean("TextEditor");
        te.spellCheck();

        //
        long a = 0,b = 0, c;
        c = java.lang.Math.abs(a-b);
    }

}
