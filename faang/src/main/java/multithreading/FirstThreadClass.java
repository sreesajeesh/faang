package multithreading;

public class FirstThreadClass {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            ThreadExtendDemo threadExtendDemo = new ThreadExtendDemo();
            threadExtendDemo.start();
        }
    }

}

class ThreadExtendDemo extends Thread {
    public void run(){
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        } catch (Exception e){
            System.out.println("Exception is caught " + e.getMessage());
        }
    }
}
