package com.home.spring.aop;

/**
 * Created by Arun on 11/9/2015.
 */
public class Circle {

    int radius;

    String name;

    Circle() {
       radius = 0;
        name="";
    }

    Circle(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Circle getInstance() {
        return this;
    }

    public void throwEx() throws Exception {
        throw new Exception("Demo Exception");
    }
}
