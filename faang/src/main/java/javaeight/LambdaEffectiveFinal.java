package javaeight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectiveFinal {
    String name = "";

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Sajeesh");
        int x = 12;

        Predicate<String> lambda = s -> {
            new LambdaEffectiveFinal().name = "Kumar";
            System.out.println("x = " + x);
            return s.isEmpty() && x%2 == 0;
        };
        filterData(al, lambda);
        LambdaEffectiveFinal lef = new LambdaEffectiveFinal();
        lef.name = "Sean"; // instance/class vars are o

        filterData(al, lambda);// lambda views 'x' as 12
        //x++;
        System.out.println(x);
    }

    public static void filterData(List<String> list, Predicate<String> lambda){
        list.removeIf(lambda);

/*        while (i.hasNext()){
            if(lambda.test(i.next())){
                i.remove();
            }
        }*/
    }
}
