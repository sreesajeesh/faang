package designpatterns.singleton;

public enum Database {

    INSTANCE;

    public void connect(){
        System.out.println("Database connected");
    }

    public void disconnect(){
        System.out.println("Database disconnected");
    }
}
