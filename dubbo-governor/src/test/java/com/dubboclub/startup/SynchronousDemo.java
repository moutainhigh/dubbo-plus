package com.dubboclub.startup;

import java.util.concurrent.SynchronousQueue;

public class SynchronousDemo {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        Thread.sleep(1000);
        System.out.println(synchronousQueue.offer("hello"));
    }
    
}
