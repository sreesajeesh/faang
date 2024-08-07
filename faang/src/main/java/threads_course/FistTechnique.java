package threads_course;

import java.util.concurrent.TimeUnit;

public class FistTechnique {

    public static void main(String[] args) {
        System.out.println("Main Thread Start here ...");
        new SecondTask();
        Thread t = new SecondTask();
        System.out.println("Main Thread Ends here ...");
    }
}

class FirstTask extends Thread {
    static int count = 0;
    int id;
    @Override
    public void run(){
        for (int i = 10; i > 0 ; i--) {
            System.out.println("<" + id + "> Tick Tick - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public FirstTask(){
        this.id = ++count;
        this.start();
    }
}
