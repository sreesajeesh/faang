package multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SumComputation implements Runnable{

    public static int sum = 0;

    @Override
    public void run() {
        System.out.println("Is the barrier broken? - " + Tester.barrier.isBroken());

        sum = 10 + 20;
        try {
            Tester.barrier.await(1000, TimeUnit.MILLISECONDS);
            System.out.println("Number of parties waiting at barrier at this point = "
            + Tester.barrier.getNumberWaiting());
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e){
            e.printStackTrace();
        }
    }
}