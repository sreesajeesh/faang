package exclusive.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {




    public static void main(String[] args) {

        String[] fruits = new String[]{"apple", "orange", "grapes", "apricot"};

        List<String> fList = new ArrayList<>(List.of(fruits));

        List<String> fruitlist = new ArrayList<>();
        fruitlist.add("apple");
        fruitlist.add("orange");
        fruitlist.add("grapes");
        fruitlist.add("apricot");

//        fruitlist.stream()
//                .filter()
        List<String> aString = new ArrayList<>();
//        for(String str : fruitlist){
//            if(str.charAt(0) == 'a'){
//                aString.add(str);
//            }
//        }

        aString = fruitlist.stream()
                .filter(obj-> obj.startsWith("a"))
                .collect(Collectors.toList());
        aString = fruitlist.stream()
                        .filter(obj-> obj.charAt(0) == 'a')
                                .collect(Collectors.toList());
        System.out.println(aString);
    }
}
