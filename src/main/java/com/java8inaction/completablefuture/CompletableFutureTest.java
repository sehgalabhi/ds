package com.java8inaction.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by abhi on 17/7/18.
 */
public class CompletableFutureTest {

    private static final List<Shop> shops = Arrays.asList(new Shop("One"),
            new Shop("Two"), new Shop("Threee"));

    public static void main(String[] args) {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
//        completableFutureTest.testClientSequential();
//        completableFutureTest.testClientParallel();
//        completableFutureTest.testClientCompletableFuture();
        completableFutureTest.testCustomExecutors();


//        completableFutureTest.testFutures();
//        completableFutureTest.testFuturesAsyncCode();
//        completableFutureTest.testFuturesAsyncLambda();
//        completableFutureTest.testFuturesAsyncException();


    }

    private void testCustomExecutors() {

        ExecutorService executor = Executors.newFixedThreadPool(10, new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        t.setName("Hello");
                        return t;
                    }
                }

        );

        List<CompletableFuture<String>> hi = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s %f", shop.getName(),
                shop.getPrice("hi")), executor)).collect(Collectors.toList());
        List<String> collect = hi.stream().map(CompletableFuture::join).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    private void testClientCompletableFuture() {

        List<CompletableFuture<String>> completableFutures = shops.stream().map(
                shop -> CompletableFuture.supplyAsync(() -> String.format("%s%f", shop.getName(),
                        shop.getPrice("hello")))).collect(toList());

        List<String> collect = completableFutures.stream().map(CompletableFuture::join).collect(toList());
        collect.stream().forEach(System.out::println);
    }

    private void testClientParallel() {
        List<String> hello = shops.parallelStream().map
                (shop -> String.format("%s%f", shop.getName(), shop.getPrice("hello")))
                .collect(toList());

        hello.stream().forEach(System.out::println);
    }

    private void testClientSequential() {
        List<String> hello = shops.stream().map
                (shop -> String.format("%s%f", shop.getName(), shop.getPrice("hello")))
                .collect(toList());

        hello.stream().forEach(System.out::println);

    }

    private List<String> findPrices(String productName) {
        return null;
    }

    private void testFuturesAsyncException() {

        Shop shop = new Shop("One");
        Future<Double> test = shop.getPriceAsyncException("test");

        try {
            Double aDouble = test.get();
            System.out.println(aDouble);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private void testFuturesAsyncLambda() {

        Shop shop = new Shop("One");
        Future<Double> test = shop.getPriceAsyncLambda("test");

        try {
            Double aDouble = test.get();
            System.out.println(aDouble);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private void testFuturesAsyncCode() {

        Shop shop = new Shop("One");
        Future<Double> test = shop.getPriceAsyncCode("test");

        try {
            Double aDouble = test.get();
            System.out.println(aDouble);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private void testFutures() {

        Shop shop = new Shop("One");
        Callable<Double> callable = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return shop.getPrice("Test");
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> submit = executor.submit(callable);
        try {
            Double aDouble = submit.get();
            System.out.println(aDouble);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}

class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String productName) {
        delay();
        Random random = new Random();
        return random.nextDouble();
    }

    private void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Future<Double> getPriceAsyncException(String productName) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {

                double price = getPrice("test");
                String s = null;
                s.hashCode();
                completableFuture.complete(price);
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        }).start();

        return completableFuture;
    }

    public Future<Double> getPriceAsyncLambda(String productName) {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> getPrice("test"));
        return completableFuture;
    }

    public Future<Double> getPriceAsyncCode(String productName) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = getPrice("test");
                completableFuture.complete(price);

            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        }).start();

        return completableFuture;
    }

    public String getName() {
        return name;
    }
}
