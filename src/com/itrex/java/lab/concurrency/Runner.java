package com.itrex.java.lab.concurrency;

public class Runner {

    public static void main(String[] args) {

        LandRover landRover = new LandRover(15);

        Thread threadA = new ThreadA(landRover);
        Thread threadB = new ThreadB(landRover);
        Thread threadC = new ThreadC(landRover);
        Thread threadD = new ThreadD(landRover);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }

}
