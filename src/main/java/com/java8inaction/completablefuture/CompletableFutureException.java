package com.java8inaction.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureException {

    public static void main(String[] args) {
        CompletableFuture<String> error_sleeping = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error sleeping", e);
            }
            if (System.currentTimeMillis() % 2 == 0) {
                throw new RuntimeException("Even time...");     // 50% chance to fail
            }
            return "Hello World!";
        });

        CompletableFuture<Void> exceptionally = error_sleeping.thenAcceptAsync(s -> {
            System.out.println("Result: " + s);
        })
                .exceptionally(e -> {
                    System.err.println("Error greeting: " + e.getMessage());
                    return null;
                });

        exceptionally.join();
    }
}
