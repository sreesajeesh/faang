package streams.partthree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCodeQuestions {

    public static void main(String[] args) {

        //Print sum of all numbers

        int[] arr = new int[]{1,3,5,7,9,10,12,14,16};
        //List<Integer> intList = Arrays.asList(1,3,5,7,9,10,12,14,16);
        List<Integer> intList = Arrays.asList(1,10,20,10,30,15,20, 1);
//        System.out.println(Arrays.stream(arr).parallel().sum());
//        System.out.println(intList.stream().parallel().reduce(Integer::sum));

        //print average
        //System.out.println(intList.stream().mapToInt(e->e).average().getAsDouble());

//        System.out.println(intList.stream().mapToInt(e -> e *e)
//                .filter(a -> a > 100)
//                .average().getAsDouble());

        //print even and odd
        /*System.out.println(intList.stream().filter(e-> e%2 == 0)
                .collect(Collectors.toList()));
        System.out.println(intList.stream().filter(e-> e%2 != 0)
                .collect(Collectors.toList()));*/

//        System.out.println(intList.stream().map(c-> c + "")
//                .filter( b -> b.startsWith("1"))
//                .map(Integer::parseInt).collect(Collectors.toList()));

        //To find duplicates
/*
        System.out.println(intList.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter((a) -> a.getValue() >1 )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()));
*/
        System.out.println(intList.stream().filter(e -> Collections.frequency(intList, e) > 1).collect(Collectors.toList()));

        System.out.println(intList.stream().max(Comparator.comparing(Integer::valueOf)).get());


        intList.stream().sorted().collect(Collectors.toList());
        intList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        //Usage of Supplier interface.
        String[] input = {"Amit", "ball", "call", "Amit", "egg"};
        Supplier<Stream<String>> inputStream = () -> Stream.of(input);
        inputStream.get().forEach(System.out::println);
        System.out.println(inputStream.get().filter(("Amit")::equals).count());

    }
}
