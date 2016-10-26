package com.home.references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by Arun on 1/3/2016.
 */
public class WeakReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCustom myCustom = new MyCustom();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        WeakReference weakReference = new WeakReference(myCustom, referenceQueue);
        System.out.println("Weak Reference Before Object is made Null " + weakReference.get());
        myCustom = null;
        System.out.println("Weak Reference After Object is made Null " + weakReference.get());
        System.gc();
        Thread.sleep(1000);
        System.out.println("Weak Reference After Object is made Null and GC" + weakReference.get());
        System.out.println("Calling Remove" + referenceQueue.remove());

    }
}
