package com.alvinlkk.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * read write lock test
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-22 23:29
 */
public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteObj book = new ReadWriteObj();
        ExecutorService pool = Executors.newCachedThreadPool();
        //read
//        for (int i = 0; i < 10; i++) {
//            pool.submit(() -> {
//                book.readContent();
//            });
//        }
//        pool.shutdown();

        //write
//        for (int i = 0; i < 10; i++) {
//            pool.submit(() -> {
//                book.writeContent("content" + ThreadLocalRandom.current().nextInt(10));
//            });
//        }
//        pool.shutdown();

        //read & write
        pool.submit(() -> {
                book.writeContent("content" + ThreadLocalRandom.current().nextInt(10));
        });
        Thread.sleep(1);
        pool.submit(() -> {
            book.readContent();
        });
        pool.shutdown();
    }
}

class ReadWriteObj {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();

    private Lock writeLock = readWriteLock.writeLock();

    private String content;

    public String readContent() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "read start ----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "read cotent:" + content);
            return content;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            readLock.unlock();
        }
    }

    public void writeContent(String content) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "write start ----");
            Thread.sleep(1000);
            this.content = content;
            System.out.println(Thread.currentThread().getName() + "write content:" + content );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
