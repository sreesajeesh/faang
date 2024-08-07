package multithreading;

public class ThirdThreadMain {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        t.setName("NotMain");
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t.getPriority());
        Thread ct = new Thread(()-> {
            for (int i = 0; i < 5; i++){
                System.out.println("Child Thread");
            }
        });
        System.out.println("Child thread priority: "
                + ct.getPriority());
        ct.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Child thread new priority: "
                + ct.getPriority());
        ct.start();
    }
}
