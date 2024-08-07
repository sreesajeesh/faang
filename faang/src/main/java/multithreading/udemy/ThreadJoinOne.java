package multithreading.udemy;

public class ThreadJoinOne {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new ThreadOne();
        Thread threadTwo = new ThreadTwo();

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("Main Thread stopped");
    }

    private static class ThreadOne extends Thread {
        @Override
        public void run(){
            try {
                System.out.println("Thread One is running");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class ThreadTwo extends Thread {
        @Override
        public void run(){
            try {
                System.out.println("Thread Two is running");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
