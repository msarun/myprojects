package com.home.hibernate.Domain;

import javax.persistence.*;

/**
 * Created by Arun on 11/27/2015.
 */

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int deptId;

    @Column
    String deptName;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
