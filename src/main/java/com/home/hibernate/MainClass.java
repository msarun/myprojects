package com.home.hibernate;

import com.home.hibernate.Domain.Address;
import com.home.hibernate.Domain.Department;
import com.home.hibernate.Domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

/**
 * Created by Arun on 11/23/2015.
 */
public class MainClass {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee = new Employee();
        employee.setEmployeeName("Shwetha");

        Department department = new Department();
        department.setDeptName("HR");
        employee.setDepartment(department);

        Address address = new Address();
        address.setAddress1("Sahakaranagar Kodigehalli");
        address.setCity("Bangalore");
        employee.setAddressList(Arrays.asList(address));

        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }
}
