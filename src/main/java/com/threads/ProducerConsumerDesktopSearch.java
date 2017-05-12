package com.threads;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by asehgal on 5/12/2017.
 */
public class ProducerConsumerDesktopSearch {

    private BlockingQueue<File> fileQueue;

    public ProducerConsumerDesktopSearch() {
        fileQueue = new ArrayBlockingQueue<>(10);
    }

    public static void main(String[] args) {
        new ProducerConsumerDesktopSearch().test();
    }

    private void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new FileCrawler(fileQueue));
        executorService.submit(new FileIndexer(fileQueue));


    }

    private class FileCrawler implements Runnable {
        private BlockingQueue<File> fileQueue;

        public FileCrawler(BlockingQueue<File> fileQueue) {
            this.fileQueue = fileQueue;
        }

        @Override
        public void run() {
            File root = new File("C:\\Users\\asehgal\\Documents\\Personal\\Learning");
            crawl(root);

        }

        private void crawl(File root) {
            File[] files = root.listFiles();
            for (File file : files
                    ) {
                if(file.isDirectory()){
                    crawl(file);
                } else
                    try {
                        fileQueue.put(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    class FileIndexer implements Runnable {
        private BlockingQueue<File> fileBlockingQueue;

        public FileIndexer(BlockingQueue<File> fileBlockingQueue) {
            this.fileBlockingQueue = fileBlockingQueue;
        }

        @Override
        public void run() {
            try {
                while (true){
                    indexFile(fileBlockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void indexFile(File take) {
            System.out.println(take.getAbsoluteFile());
        }
    }
}
