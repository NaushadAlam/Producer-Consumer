package com.producerconsumer.naushad;

import java.util.Vector;

/**
 * Created by kkk on 3/7/2015.
 */
public  class Main {

    public static void main(String[] args){
        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "consumer");
        prodThread.start();
        consThread.start();
    }

}
