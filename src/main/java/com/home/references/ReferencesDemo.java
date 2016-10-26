package com.home.references;

import java.lang.ref.*;
import java.util.WeakHashMap;

/**
 * Created by Arun on 1/2/2016.
 */
public class ReferencesDemo {
    public static void main(String[] args) throws InterruptedException {
        String obj = new String("Arun");


        WeakReference weak = new WeakReference(obj);
        System.out.println("Weak Ref Id: " + weak);
        System.out.println(weak.get().toString());
        obj = null;
        System.gc();
        System.out.println(weak.get());

        obj = new String("Arun");
        SoftReference softReference = new SoftReference(obj);
        System.out.println("Soft Ref Id: " + softReference);
        obj = null;
        System.gc();
        System.out.println(softReference.get());

        obj = new String("Arun");
        final ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(obj,  referenceQueue);
        obj = null;
        Thread t = new Thread(() -> {

            System.out.println("Phantom Ref Id: " + phantomReference.get()); // Always returns null

            try {
                Reference phantomReference1 = referenceQueue.remove();
                System.out.println("Phantom Ref Notification when its GC'd: ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(2000);
        System.gc();



    }


}
