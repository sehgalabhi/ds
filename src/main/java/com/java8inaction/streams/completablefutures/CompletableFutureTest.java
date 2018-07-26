package com.java8inaction.streams.completablefutures;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest {

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<BigDecimal> hello = shop.getPrice("hello");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println(invocationTime);
        try {
            BigDecimal bigDecimal = hello.get();
            System.out.println(bigDecimal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println(retrievalTime);
    }

}

class Shop {
    public Future<BigDecimal> getPrice(String product) {

        CompletableFuture<BigDecimal> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                BigDecimal price = calculatePrice();
                completableFuture.complete(price);
            } catch (Exception ex){
                completableFuture.completeExceptionally(ex);
            }

        }).start();
        return completableFuture;
    }

    private BigDecimal calculatePrice() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();

        return new BigDecimal(random.nextDouble());
    }
}

