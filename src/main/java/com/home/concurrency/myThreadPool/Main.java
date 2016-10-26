package com.home.concurrency.myThreadPool;

/**
 * Created by Arun on 12/2/2015.
 */
public class Main {
    public static void main(String[] args) {


        MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(2, 5);
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
