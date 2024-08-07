package multithreading.udemy;

public class ThreadCreation {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> { System.out.println("We are now in thread " + Thread.currentThread().getName());
            System.out.println("Current Thread Priority : " + Thread.currentThread().getPriority());
        });

        thread.setName("Worker Thread One");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread " + Thread.currentThread().getName() + " before starting new thread");
        thread.start();
        System.out.println("We are in thread " + Thread.currentThread().getName() + " after starting new thread");

        Thread.sleep(10000);
    }
}
