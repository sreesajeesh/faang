package multithreading;

import java.util.concurrent.TimeUnit;

public class WhichThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = ()-> {
            System.out.print(Thread.currentThread().getName() + " ");
        };
        Thread t = new Thread(task);
        t.start();
        //Thread.sleep(100);
        System.out.println("Got completed");
    }
}
