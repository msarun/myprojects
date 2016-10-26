package com.home.spring.aop;

import java.time.LocalDate;

/**
 * Created by Arun on 11/12/2015.
 */
public class CircleAuditImpl implements CircleAudit {

    LocalDate localDate;

    @Override
    public LocalDate getLastModifiedDate() {
        return localDate;
    }

    @Override
    public void setLastModifiedDate(LocalDate localDate) {
        this.localDate = localDate;

    }
}
