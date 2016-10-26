package com.home.j2ee.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Arun on 11/12/2015.
 */
public class HelloWorldServlet extends HttpServlet {

    ServletConfig servletConfig;

    ServletContext servletContext;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.servletContext = request.getServletContext();
        this.servletConfig = getServletConfig();

        try {
            PrintWriter out = response.getWriter();
            out.println("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
