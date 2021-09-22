package com.itrex.java.lab.concurrency;

import java.util.function.IntConsumer;

public class LandRover {

    private final int n;
    private volatile int numCount;

    public LandRover(int n) {
        if (n < 1 || n > 50) {
            throw new IllegalArgumentException("Недопустимое значение. Введите число n от 1 - до 50");
        }
        this.n = n;
        this.numCount = 1;
    }

    // printLand.run() outputs "land".
    public synchronized void land(Runnable printLand) throws InterruptedException {
        while (numCount <= n) {
            if (numCount % 3 == 0 && numCount % 5 != 0) {
                startSequenceAndComma(numCount);
                printLand.run();
                endSequence(numCount);
                numCount++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printRover.run() outputs "rover".
    public synchronized void rover(Runnable printRover) throws InterruptedException {
        while (numCount <= n) {
            if (numCount % 5 == 0 && numCount % 3 != 0) {
                startSequenceAndComma(numCount);
                printRover.run();
                endSequence(numCount);
                numCount++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printLandRover.run() outputs "landrover".
    public synchronized void landrover(Runnable printLandRover) throws InterruptedException {
        while (numCount <= n) {
            if (numCount % 3 == 0 && numCount % 5 == 0) {
                startSequenceAndComma(numCount);
                printLandRover.run();
                endSequence(numCount);
                numCount++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (numCount <= n) {
            if (numCount % 3 != 0 && numCount % 5 != 0) {
                startSequenceAndComma(numCount);
                printNumber.accept(numCount);
                endSequence(numCount);
                numCount++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printing the beginning of the sequence and commas
    private void startSequenceAndComma(int numCount) {
        if (numCount == 1) {
            System.out.print("[");
        } else if (numCount > 1) {
            System.out.print(",");
        }
    }

    // printing the end of the sequence
    private void endSequence(int numCount) {
        if (numCount == n) {
            System.out.println("]");
        }
    }

}