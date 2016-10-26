package com.home.innerClasses.nonStatic;

/**
 * Created by Arun on 12/1/2015.
 */
public class InnerClassInMethod {
    public void methodWithInnerClass() {
        class InnerClass {
            public void print() {
                System.out.println("Printing from a InnerClass in a method");
            }
        }
        new InnerClass().print();

    }

    public static void main(String[] args) {
        InnerClassInMethod out = new InnerClassInMethod();

        out.methodWithInnerClass();
    }
}
