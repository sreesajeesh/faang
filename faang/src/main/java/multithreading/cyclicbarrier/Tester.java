package multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tester implements Runnable {

    public static CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) {

        Tester test = new Tester();
        Thread testerThread = new Thread(test);
        testerThread.start();

    }


    @Override
    public void run() {
        System.out.println("Number of parties required to trip the barrier = "+
                barrier.getParties());
        System.out.println("Sum of product and sum = " + (ProductComputation.product +
                SumComputation.sum));

        ProductComputation pc = new ProductComputation();
        SumComputation sc = new SumComputation();

        Thread productThread = new Thread(pc);
        Thread sumThread = new Thread(sc);

        productThread.start();

        sumThread.start();

        try{
            Tester.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }

        System.out.println("Sum of product and sum = " + (ProductComputation.product +
                SumComputation.sum));

        barrier.reset();
        System.out.println("Barrier reset successful");
    }
}
