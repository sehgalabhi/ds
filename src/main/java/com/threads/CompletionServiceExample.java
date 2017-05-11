package com.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by asehgal on 5/11/2017.
 */
public class CompletionServiceExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new CompletionServiceExample().test();
    }

    private void test() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        int nThreads = 500;
        for (int i = 0; i < nThreads; i++) {
            completionService.submit(new CallableTask(i));
        }

        for (int i = 0; i < nThreads; i++) {
            System.out.println(completionService.take().get());
        }

    }

    private class CallableTask implements Callable<String> {
        private int number;

        public CallableTask(int i) {
            number = i;
        }

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName() + " --Provided number " + number;
        }
    }

}
