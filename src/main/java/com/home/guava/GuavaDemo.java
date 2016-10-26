package com.home.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Arun on 1/7/2016.
 */
public class GuavaDemo {
    public static void main(String[] args) throws ExecutionException {

        CacheLoader cacheLoader = new CacheLoader() {
            @Override
            public Employee load(Object key) throws Exception {
                return getFromDB((String)key);
            }
        };

        LoadingCache<String, Employee> employeeCache = CacheBuilder.newBuilder()
                .initialCapacity(5)
                .maximumSize(10)
                .expireAfterAccess(30, TimeUnit.MINUTES)
                .build(cacheLoader);


        System.out.println("Invocation #1");
        System.out.println(employeeCache.get("100"));
        System.out.println(employeeCache.get("103"));
        System.out.println(employeeCache.get("110"));

        //second invocation, data will be returned from cache
        System.out.println("Invocation #2");
        System.out.println(employeeCache.get("100"));
        System.out.println(employeeCache.get("103"));
        System.out.println(employeeCache.get("110"));

    }

    public static Employee getFromDB(String empId) {
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map<String, Employee> database = new HashMap<String, Employee>();

        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);

        System.out.println("Database hit for" + empId);

        return database.get(empId);
    }
}
