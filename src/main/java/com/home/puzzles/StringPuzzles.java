package com.home.puzzles;

/**
 * Created by Arun on 12/7/2015.
 */
public class StringPuzzles {
    public static void main(String[] args) {
        String s = "arun";
        String s1 = new String("arun");
        String s2 = s1.intern();
        System.out.print("s==s1 " );        System.out.println(s==s1);
        System.out.print("s==s2 " );        System.out.println(s==s2);
        System.out.print("s1==s2 " );       System.out.println(s1==s2);
    }
}
