package threads_course;

import java.util.concurrent.TimeUnit;

public class SecondTechnique {

    public static void main(String[] args) {
        System.out.println("Main Thread Start here ...");
        new SecondTask().start();
        Thread t = new SecondTask();
        t.start();
        System.out.println("Main Thread Ends here ...");
    }
}

class SecondTask extends Thread {
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

    public SecondTask(){
        this.id = ++count;
    }
}
