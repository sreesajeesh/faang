package multithreading;

public class SecondThreadState implements Runnable {

    public static Thread thread1;
    public static SecondThreadState obj;

    public static void main(String[] args) {
        obj = new SecondThreadState();
        thread1 = new Thread(obj);

        System.out.println(
                "State of thread1 after creating it - "
                        + thread1.getState());
        thread1.start();

        System.out.println(
                "State of thread1 after calling .start() method on it - "
                        + thread1.getState());
    }

    @Override
    public void run() {
        ThreadNext myThread = new ThreadNext();
        Thread thread2 = new Thread(myThread);
        System.out.println(
                "State of thread2 after creating it - "
                        + thread2.getState());
        thread2.start();
        System.out.println(
                "State of thread2 after calling .start() method on it - "
                        + thread2.getState());
        try {
            // moving thread1 to timed waiting state
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 after calling .sleep() method on it - "
                        + thread2.getState());
        try {
            // waiting for thread2 to die
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 when it has finished it's execution - "
                        + thread2.getState());
    }
}

class ThreadNext implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(1500);
        }catch (Exception e){
            System.out.println("Exception is caught " + e.getMessage());
        }

        System.out.println(
                "State of thread1 while it called join() method on thread2 -"
                        + SecondThreadState.thread1.getState());

        try {
            Thread.sleep(200);
        }catch (Exception e){
            System.out.println("Exception is caught " + e.getMessage());
        }
    }
}
