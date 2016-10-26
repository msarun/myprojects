package com.home.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Arun on 1/9/2016.
 */
public class Guava_Demo_2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CacheLoader<String,Employee> cacheLoader = new CacheLoader<String, Employee>() {
            @Override
            public Employee load(String key) throws Exception {
                return getKeyFromDataBase(key);
            }
        };
        LoadingCache cache = CacheBuilder.newBuilder()
                .concurrencyLevel(1)
                .initialCapacity(100)
                .expireAfterAccess(1000, TimeUnit.MILLISECONDS)
                .recordStats()
                .build(cacheLoader);

        System.out.println(cache.get("00134002"));
        System.out.println(cache.get("00087138"));
        System.out.println(cache.get("123456"));

        System.out.println("--------------------------------------");
        System.out.println(cache.get("00134002"));
        System.out.println(cache.get("00087138"));
        System.out.println(cache.get("123456"));

        Thread.sleep(10000);
        System.out.println("--------------------------------------");
        System.out.println(cache.get("00134002"));
        System.out.println(cache.get("00087138"));
        System.out.println(cache.get("123456"));

        System.out.println(cache.stats());

    }

    private static Employee getKeyFromDataBase(String key) {
        Employee emp1 = new Employee("Arun", "Tsy", "00134002");
        Employee emp2 = new Employee("Kiran", "Margin", "00087138");
        Employee emp3 = new Employee("Shwetha", "HR", "123456");

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(emp1.getEmplD(), emp1);
        employeeMap.put(emp2.getEmplD(), emp2);
        employeeMap.put(emp3.getEmplD(), emp3);

        System.out.println("Retrieving Key from DB");
        return employeeMap.get(key);


    }
}
