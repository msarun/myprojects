package com.home.innerClasses.nonStatic;

/**
 * Created by Arun on 11/30/2015.
 */
public class OuterAnonymousDemo {
    String text = "Outer class text";

    public static void main(String[] args) {
        AnonymousDemo demo = new AnonymousDemo() {
            @Override
            public void test() {
                System.out.println("Anonymous Demo");
            }
        };
        demo.test();

        AnonymousClassDemo classDemo = new AnonymousClassDemo() {
            @Override
            public void test() {
                super.test();
                System.out.println("Overridden in Anonymous class");
            }
        };
        classDemo.test();
    }

}

interface AnonymousDemo {
    public void test();
}


class AnonymousClassDemo {
    public  void test() {
        System.out.println("Base class ");
    }
}