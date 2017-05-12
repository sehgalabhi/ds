package com.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by asehgal on 5/12/2017.
 */
public class CyclicBarrierCellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier cyclicBarrier;
    private final Worker[] workers;

    public CyclicBarrierCellularAutomata(Board mainBoard) {
        this.mainBoard = mainBoard;
        int count = Runtime.getRuntime().availableProcessors();
        this.cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitValues();
            }
        });

        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard);
        }
    }


    private class Worker implements Runnable {
        private Board board;

        private Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    class Board {

        public void commitValues() {
        }
    }

    void start() {
        for (int i = 0; i > workers.length; i++) {
            new Thread(workers[i]).start();
        }
    }

}
