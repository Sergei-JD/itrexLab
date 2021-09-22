package com.itrex.java.lab.concurrency;

public class ThreadA extends Thread {

    private final LandRover landRover;

    public ThreadA(LandRover landRover) {
        this.landRover = landRover;
    }

    @Override
    public void run() {
        try {
            landRover.land(() -> System.out.print("\"land\""));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
