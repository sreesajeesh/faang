package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class SixthThreadAtomic {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        Thread t1 = new Thread(t, "t1");
        t1.start();

        Thread t2 = new Thread(t, "t2");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count=" + t.getCount());
    }
}

class MyThread extends Thread {
    private final AtomicInteger count = new AtomicInteger();

    public void run(){
        for (int i = 1; i <= 5; i++) {

            try {
                Thread.sleep(i * 100);
                //count++;
                count.getAndIncrement();
            }
            catch (InterruptedException
                    e) { // throwing an exception
                System.out.println(e);
            }
        }
    }

    public int getCount() { return this.count.get(); }
}
