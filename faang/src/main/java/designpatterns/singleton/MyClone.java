package designpatterns.singleton;

public class MyClone implements Cloneable {
    @Override
    public MyClone clone() {
        try {
            return (MyClone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
