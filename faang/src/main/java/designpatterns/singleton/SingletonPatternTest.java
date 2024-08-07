package designpatterns.singleton;

public class SingletonPatternTest {

    public static void main(String[] args) throws CloneNotSupportedException{

        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2  = (LazySingleton) instance1.clone();;
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
