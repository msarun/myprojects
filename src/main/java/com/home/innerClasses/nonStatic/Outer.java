package com.home.innerClasses.nonStatic;

/**
 * Created by Arun on 11/30/2015.
 */
public class Outer {
    private String text = "text from Outer class";

    private static String staticOuterText = "Text from Outer class in static context";

    private class InnerClass {
        private String text = "text from Inne Class";

        public void print() {
            System.out.println(text);
            System.out.println(staticOuterText);
            System.out.println(Outer.this.text);
        }
    }

    public static void main(String[] args) {
      Outer outer = new Outer();
      Outer.InnerClass inner = outer.new InnerClass();
        inner.print();
    }

}
