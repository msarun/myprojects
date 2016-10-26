package com.home.concurrency.myThreadPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arun on 12/2/2015.
 */
public class MyThreadPoolExecutor {

    private int coreSize;

    private int maxCoreSize;

    private LinkedList<MyWorker> threadPool = new LinkedList<>();

    private MyRunnableQueue runnableQueue = new MyRunnableQueue(Integer.MAX_VALUE);

    MyThreadPoolExecutor(int coreSize, int maxCoreSize) {
        this.coreSize = coreSize;
        this.maxCoreSize = maxCoreSize;
    }

    public void submit(Runnable r) {
        if ((threadPool.size() < coreSize) || (threadPool.size() > coreSize && runnableQueue.isQueueFull())) {
            MyWorker myWorker = new MyWorker(runnableQueue);
            threadPool.add(myWorker);
            new Thread(myWorker).start();
        }
        runnableQueue.enqueue(r);
    }

    public void shutDown() {
        /*for(Runnable r : runnableQueue.) {

        }*/

    }

    public void shutDownNow() {

    }
}
