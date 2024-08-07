package designpatterns.singleton;

public class LazySingletonClone extends MyClone {

    private LazySingletonClone(){

    }

    private static LazySingletonClone instance;

    public static LazySingletonClone getInstance(){
        if(instance == null){
            synchronized (LazySingletonClone.class){
                if(instance == null){
                    instance = new LazySingletonClone();
                }
            }

        } else {
            return instance;
        }
        return null;
    }
}
