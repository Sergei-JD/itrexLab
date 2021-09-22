package com.itrex.java.lab.concurrency;

public class ThreadB extends Thread{

    private final LandRover landRover;

    public ThreadB(LandRover landRover) {
        this.landRover = landRover;
    }

    @Override
    public void run() {
        try {
            landRover.rover(() -> System.out.print("\"rover\""));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
