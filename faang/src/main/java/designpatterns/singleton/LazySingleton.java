package designpatterns.singleton;

public class LazySingleton extends MyClone{

    private LazySingleton(){

    }

    private static LazySingleton instance;

    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
