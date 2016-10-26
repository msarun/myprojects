package com.home.puzzles;

/**
 * Created by Arun on 11/23/2015.
 */
public class PrintTree {
    public static void main(String[] args) {
        int  n = 6;
        for(int i=1; i <= n ; i++) {
            int whiteSpaces = n-i;

            while(whiteSpaces>0) {
                System.out.print(" ");
                whiteSpaces--;
            }
            for(int j =0; j<i; j++)
                System.out.print("#");
            System.out.println();
        }
    }
}
