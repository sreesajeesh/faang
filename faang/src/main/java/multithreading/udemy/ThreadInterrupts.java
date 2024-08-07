package multithreading.udemy;

public class ThreadInterrupts {

    public static void main(String[] args) {

        Thread interruptedThread = new Thread(new InterruptedThread());
        interruptedThread.setName("Interrupted Thread");
        InterruptingThread interruptingThread = new InterruptingThread();
        interruptingThread.setInterruptedThread(interruptedThread);

        Thread thread = new Thread(interruptingThread);
        thread.setName("Interrupting Thread");
        interruptedThread.start();
        thread.start();


    }

    private static class InterruptedThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " got interrupted");
                return;
            }
        }
    }

    private static class InterruptingThread extends Thread{

        Thread interruptedThread;

        public void setInterruptedThread(Thread interruptedThread){
            this.interruptedThread = interruptedThread;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " going to interrupt " + interruptedThread.getName());
                interruptedThread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
