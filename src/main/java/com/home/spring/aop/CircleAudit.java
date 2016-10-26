package com.home.spring.aop;

import java.time.LocalDate;

/**
 * Created by Arun on 11/12/2015.
 */

//Demo for Introduction/@ParentAdvice annotations
public interface CircleAudit {
    LocalDate getLastModifiedDate();

    void setLastModifiedDate(LocalDate localDate);
}
