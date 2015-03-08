package com.producerconsumer.naushad;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kkk on 3/7/2015.
 */
public class Consumer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;
    public Consumer(Vector sharedQueue, int size){
        this.sharedQueue = sharedQueue;
        SIZE = size;
    }


    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Consumed :" + consume());
                Thread.sleep(500);
            }catch (InterruptedException e){
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    private int consume() throws InterruptedException {

        while (sharedQueue.isEmpty()) {
            synchronized(sharedQueue) {
                System.out.println("Queue is Empty " + Thread.currentThread().getName()
                    + " is waiting, size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }
        synchronized (sharedQueue){
            sharedQueue.notifyAll();
            return (Integer)sharedQueue.remove(0);
        }
    }
}
