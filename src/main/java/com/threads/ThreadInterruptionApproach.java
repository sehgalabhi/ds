package com.threads;

/**
 * Created by asehgal on 5/15/2017.
 */
public class ThreadInterruptionApproach {
    public static void main(String[] args) {
        new ThreadInterruptionApproach().test();
    }

    private void test() {
        InterruptionRunnable interruptionRunnable = new InterruptionRunnable();
        Thread t1 = new Thread(interruptionRunnable);
        t1.start();

        try {
            Thread.sleep(10);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());


    }

    private class InterruptionRunnable implements Runnable {

        private boolean interrupted = false;
        @Override
        public void run() {

                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Keep on continuing");
                    try {
                        Thread.sleep(23);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }



        }

    }
}
