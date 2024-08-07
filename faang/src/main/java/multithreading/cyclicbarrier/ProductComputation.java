package multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;

public class ProductComputation implements Runnable{
    public static int product = 1;
    @Override
    public void run() {
        product =  2 * 3;
        try {
            Tester.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}

