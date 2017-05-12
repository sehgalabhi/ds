package com.threads;

import java.util.concurrent.CountDownLatch;

/**
 * Created by asehgal on 5/12/2017.
 */
public class TestHarnessCountDownLatch {
    int nThreads = 10;
    private CountDownLatch startGate = new CountDownLatch(1);
    private CountDownLatch endGates = new CountDownLatch(nThreads);

    public static void main(String[] args) {
        new TestHarnessCountDownLatch().test();
    }

    private void test() {

        long startTime= System.currentTimeMillis();

        for (int n = 0; n < 10; n++) {
            Runnable runnable = new LatchRunnable(startGate, endGates);
            new Thread(runnable).start();
        }
        startGate.countDown();

        System.out.println("All threads must start now");
        try {
            endGates.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime= System.currentTimeMillis();
        System.out.println("Total time " + (endTime - startTime));


    }

    class LatchRunnable implements Runnable {

        private CountDownLatch startGate;
        private CountDownLatch endGates;

        public LatchRunnable(CountDownLatch startGate, CountDownLatch endGates) {
            this.startGate = startGate;
            this.endGates = endGates;
        }

        @Override
        public void run() {
            try {
                startGate.await();
                System.out.println("1234");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGates.countDown();
            }
        }
    }
}
