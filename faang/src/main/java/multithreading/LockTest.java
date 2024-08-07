package multithreading;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        TestResource testResource = new TestResource();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new DisplayJob(testResource), "Thread " + i);
        }
        for (int i = 5; i < 10; i++) {
            threads[i] = new Thread(new ReadJob(testResource), "Thread " + i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

class DisplayJob implements Runnable {

    private TestResource testResource;

    public DisplayJob(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public void run() {
        System.out.println("display job");
        testResource.displayRecord(new Object());
    }
}

class ReadJob implements Runnable {
    private TestResource testResource;

    public ReadJob(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public void run() {
        System.out.println("read job");
        testResource.readRecord(new Object());
    }
}

class TestResource {
    private final Lock displayQueueLock = new ReentrantLock();
    private final Lock readQueueLock = new ReentrantLock();

    public void displayRecord(Object document){
        final Lock displayLock = this.displayQueueLock;
        displayLock.lock();
        try {
            Long duration =
                    (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().
                    getName() + ": TestResource: display a Job"+
                    " during " + (duration / 1000) + " seconds ::"+
                    " Time - " + new Date());
            Thread.sleep(duration);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.printf("%s: The document has been"+
                    " displayed\n", Thread.currentThread().getName());
            displayLock.unlock();
        }
    }

    public void readRecord(Object document){
        final Lock readLock = this.readQueueLock;
        readLock.lock();
        try {
            Long duration =
                    (long) (Math.random() * 10000);
            System.out.println
                    (Thread.currentThread().getName()
                            + ": TestResource: reading a Job during " +
                            (duration / 1000) + " seconds :: Time - " +
                            new Date());
            Thread.sleep(duration);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.printf("%s: The document has"+
                    " been read\n", Thread.currentThread().getName());
            readQueueLock.unlock();
        }
    }
}