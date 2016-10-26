package com.home.innerClasses.staticInnerClasses;

/**
 * Created by Arun on 11/30/2015.
 */
public class OuterClass {
    private String outerText = "text from Outer class";

    private static String staticOuterText = "Text from Outer class in static context";

    static class InnerClass {
        private String text = "text from Inne Class";

        public void print() {
            System.out.println(text);
            System.out.println(staticOuterText);
            // Not accessible since in static context System.out.println(outerText);
        }
    }

    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.print();
    }
}
