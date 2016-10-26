package com.home.concurrency.myThreadPool;

/**
 * Created by Arun on 12/2/2015.
 */
public class MyWorker implements Runnable{

    MyRunnableQueue queue;

    MyWorker(MyRunnableQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true) {
            Runnable r = queue.deQueue();
            r.run();
        }
    }
}
