package streams.parttwo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        sumOfNumbers();
        sumOfIntegers();
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

    public static void sumOfNumbers(){
        List<Integer> intList = Arrays.asList(12,23,34,45,56,67,78,89,90);

        int sum = intList.stream().parallel().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void sumOfIntegers() throws ExecutionException, InterruptedException {
        List<Integer> intList = Arrays.asList(12,23,34,45,56,67,78,89,90);
        ForkJoinPool customThreadPool = new ForkJoinPool();
        int sum = customThreadPool.submit(() -> intList.parallelStream().reduce(0, Integer::sum)).get();
        System.out.println(sum);
    }

}
