package com.producerconsumer.naushad;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kkk on 3/7/2015.
 */
public class Producer implements Runnable {
    
    private final Vector sharedQueue;
    private final int SIZE;
    public Producer(Vector sharedQueue, int size){
        this.sharedQueue = sharedQueue;
        SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 1 ;  ; i++){
            try {
                produce(i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        //wait when queue is full
        while (sharedQueue.size() == SIZE){
            synchronized (sharedQueue){
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting, size "+ sharedQueue.size());
                sharedQueue.wait();
            }
        }

        //produceing element and notifying consumer
        synchronized (sharedQueue){
            System.out.println("Producer : " + i);
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}
