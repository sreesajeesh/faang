package multithreading;

public class FourthThreadRunnable {

    public static void main(String[] args) {
        System.out.println("Main thread is- "
                + Thread.currentThread().getName());
        Thread th = new Thread(new FourthThreadRunnable().new RunnableImpl());
        th.start();
    }

    private class RunnableImpl implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()
                    + ", executing run() method!");
        }
    }
}
