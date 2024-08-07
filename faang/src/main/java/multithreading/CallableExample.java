package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

interface CallerInterface {
    Integer ten = 10;
}
class CallableMessage implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello World";
    }
}
public class CallableExample {

    static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableMessage task = new CallableMessage();
        Future<String> message = executor.submit(task);
        System.out.println(message.get());
        executor.shutdownNow();
    }
}
