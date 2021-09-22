package com.itrex.java.lab.concurrency;

public class ThreadD extends Thread {

    private final LandRover landRover;

    public ThreadD(LandRover landRover) {
        this.landRover = landRover;
    }

    @Override
    public void run() {
        try {
            landRover.number(System.out::print);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
