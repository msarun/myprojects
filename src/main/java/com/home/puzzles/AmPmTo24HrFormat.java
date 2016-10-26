package com.home.puzzles;

/**
 * Created by Arun on 11/23/2015.
 */
public class AmPmTo24HrFormat {
    public static void main(String[] args) {
        String time = "12:00:00AM";
        int hr=0;

        String []tokens = time.split(":");
        if(tokens[2].endsWith("PM")) {
            hr += 12;
        }
        hr += Integer.parseInt(tokens[0]);
        String sec = tokens[2].substring(0,2);
        System.out.println(hr + ":" +tokens[1] + ":" + sec);
    }
}
