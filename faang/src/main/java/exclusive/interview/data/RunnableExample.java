package exclusive.interview.data;

import java.util.function.Consumer;

public class RunnableExample implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        RunnableExample re = new RunnableExample();

        Consumer<String> ct = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable helloWorld = () -> ct.accept("Hello World");

            }
        });
        t1.start();
    }
}
