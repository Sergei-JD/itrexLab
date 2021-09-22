package com.itrex.java.lab.concurrency;

public class ThreadC extends Thread {

    private final LandRover landRover;

    public ThreadC(LandRover landRover) {
        this.landRover = landRover;
    }

    @Override
    public void run() {
        try {
            landRover.landrover(() -> System.out.print("\"landrover\""));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}