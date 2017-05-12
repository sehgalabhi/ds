package com.threads;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by asehgal on 5/12/2017.
 */
public class CachingImplementation {


    interface Computable<A, V> {
        V compute(A arg) throws InterruptedException;
    }

    class ExpensiveFunction implements Computable<String, BigInteger> {

        @Override
        public BigInteger compute(String arg) throws InterruptedException {
            // expensive computation

            return new BigInteger(arg);
        }
    }

    //scalabiltiy issue
    private class Memorizer1<A,V> implements Computable<A,V>{
        private final Map<A,V> cache = new HashMap<A, V>();
        final Computable<A,V> expensiveFunction;

        Memorizer1(Computable<A, V> expensiveFunction) {
            this.expensiveFunction = expensiveFunction;
        }

        @Override
        public synchronized V compute(A arg) throws InterruptedException {
            V result = cache.get(arg);
            if(result == null){
                result = expensiveFunction.compute(arg);
                cache.put(arg, result);
            }
            return result;
        }
    }

    //
    private class Memorizer2<A,V> implements Computable<A,V>{
        private final Map<A,V> cache = new ConcurrentHashMap<A, V>();
        final Computable<A,V> expensiveFunction;

        Memorizer2(Computable<A, V> expensiveFunction) {
            this.expensiveFunction = expensiveFunction;
        }

        @Override
        public synchronized V compute(A arg) throws InterruptedException {
            V result = cache.get(arg);
            if(result == null){
                result = expensiveFunction.compute(arg);
                cache.put(arg, result);
            }
            return result;
        }
    }


    //non atomic put
    private class Memorizer3<A,V> implements Computable<A,V>{
        private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
        final Computable<A,V> expensiveFunction;

        private Memorizer3(Computable<A, V> expensiveFunction) {
            this.expensiveFunction = expensiveFunction;
        }

        @Override
        public V compute(A arg) throws InterruptedException {
            Future<V> vFuture = cache.get(arg);
            if(vFuture == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return expensiveFunction.compute(arg);
                    }
                };
                FutureTask<V> vFutureTask = new FutureTask<V>(eval);
                cache.put(arg, vFutureTask);
                vFutureTask.run();
            }
            try {
                return vFuture.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    private class Memorizer4<A,V> implements Computable<A,V>{
        private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
        final Computable<A,V> expensiveFunction;

        private Memorizer4(Computable<A, V> expensiveFunction) {
            this.expensiveFunction = expensiveFunction;
        }

        @Override
        public V compute(A arg) throws InterruptedException {
            Future<V> vFuture = cache.get(arg);
            if(vFuture == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return expensiveFunction.compute(arg);
                    }
                };
                FutureTask<V> vFutureTask = new FutureTask<V>(eval);
                cache.putIfAbsent(arg, vFutureTask);
                vFutureTask.run();
            }
            try {
                return vFuture.get();
            } catch (ExecutionException e) {
                cache.remove(vFuture);
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}

