package javaeight.collections;

import java.util.Arrays;
import java.util.List;

public class ListCode {

    public static void main(String[] args) {
        factoryMethod();
    }

    public static void factoryMethod(){
        String[] array = new String[]{"Alpha", "Beta", "Charlie"};
        List<String> asList = Arrays.asList(array);
        List<String> of = List.of(array); //immutable if changes done in array change is not reflected in list.of
        List<String> copy = List.copyOf(asList); //immutable if changes done in array change is not reflected in list.of

        array[0] = "Delta";
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

        asList.set(1, "Echo");
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

        //of.set(1, "Gamma");
        System.out.println(Arrays.toString(array));
        System.out.println(asList);
        System.out.println(of);

        //copy.set(2, "Teta");
        System.out.println(Arrays.toString(array));
        System.out.println(asList);
        System.out.println(of);
        System.out.println(copy);
    }
}
