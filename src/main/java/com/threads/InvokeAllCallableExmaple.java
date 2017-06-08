package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by asehgal on 5/15/2017.
 */
public class InvokeAllCallableExmaple {

    public static void main(String[] args) {
        new InvokeAllCallableExmaple().test();
    }

    private void test() {
        List<QuoteTask> tasks = new ArrayList();

        for (int i = 0; i < 10; i++) {
            tasks.add(new QuoteTask());
        }

        List<Integer> travelQuotes = new ArrayList<>();


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks, 2, TimeUnit.SECONDS);

            for (Future<Integer> futureVar : futures
                    ) {
                travelQuotes.add(futureVar.get());
            }

            travelQuotes.forEach(travelQuote -> System.out.println(travelQuote));

            for (Integer travelQuote :
                travelQuotes    ) {
                System.out.println(travelQuote);
            }
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    class QuoteTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

    interface TravelQuote {
        Integer test();
    }
}
