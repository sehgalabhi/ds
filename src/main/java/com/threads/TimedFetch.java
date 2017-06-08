package com.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by asehgal on 5/15/2017.
 */
public class TimedFetch {

    public static void main(String[] args) {
        new TimedFetch().test();
    }

    private void test() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(new TimedRunnable());

        try {
            System.out.println(future.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    class TimedRunnable implements Callable<Integer>{


        @Override
        public Integer call() throws Exception {
            return 4;
        }
    }
}
