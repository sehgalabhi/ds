package com.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by asehgal on 5/12/2017.
 */
public class FutureTaskExample {

    private final FutureTask<ProductInfo> futureTask = new FutureTask<>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return new ProductInfo();
        }
    });

    private Thread thread = new Thread(futureTask);

    private void start() {
        thread.start();
    }

    private ProductInfo get() {
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable throwable = e.getCause();
            e.printStackTrace();
        }
        return null;
    }

    class ProductInfo {

    }
}
