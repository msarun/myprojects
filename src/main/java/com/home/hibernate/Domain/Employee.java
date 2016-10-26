package com.home.hibernate.Domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arun on 11/27/2015.
 */

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name="Employee_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;


    @Column(name="Employee_Name")
    private String employeeName;

    @OneToMany
    private List<Address> addressList;

    @OneToOne
    private Department department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
