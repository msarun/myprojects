package com.home.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by Arun on 1/3/2016.
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCustom myCustom = new MyCustom();

        // Finalise method calls too slow in Phantom(need to comment sout in finalize() )
        final ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(myCustom, referenceQueue);
        myCustom = null;
        new Thread(() -> {
            System.out.println("Phantom Ref get() always returns null " + phantomReference.get());

            try {

                Reference newRef = referenceQueue.remove();
                System.out.println("Phantom Ref post GC, ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        Thread.sleep(2000);
        System.gc();


     /*   MyCustom obj = new MyCustom();
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
*/

    }
}
