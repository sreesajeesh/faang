package designpatterns.singleton;

public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){

    }

    private static class Singleton{
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();

    }

    public static LazyInnerClassSingleton getInstance(){
        return Singleton.instance;
    }
}
