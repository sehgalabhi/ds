package com.threads;

/**
 * Created by asehgal on 5/15/2017.
 */

// not good as if thread is in bloacking state, it will never listen to cancellation
public class ThreadCancellationApproach {
    private volatile boolean cancelled;

    public static void main(String[] args) {
        new ThreadCancellationApproach().test();
    }

    private void test() {
        CancellationPossible runnable = new CancellationPossible();
        new Thread(runnable).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cancelled = true;
    }

    private class CancellationPossible implements Runnable {
        @Override
        public void run() {
            int i =0;

            while (!cancelled){
                System.out.println("Running " + i);
                i++;
            }
        }
    }
}
