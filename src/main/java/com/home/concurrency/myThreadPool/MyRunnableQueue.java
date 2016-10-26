package com.home.concurrency.myThreadPool;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Arun on 12/2/2015.
 */
public class MyRunnableQueue {

    int maxLimit;

    MyRunnableQueue(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    private LinkedBlockingDeque<Runnable> runnableList = new LinkedBlockingDeque<>();

    public void enqueue(Runnable r) {

            //runnableList.put(r);
            runnableList.add(r);
            notifyAll();

    }

    public Runnable deQueue() {
        Runnable r = null;
        try {
             //r = runnableList.take();
            r = runnableList.poll();
            if(r == null) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public boolean isQueueFull() {
        return maxLimit == runnableList.size();
    }
}
