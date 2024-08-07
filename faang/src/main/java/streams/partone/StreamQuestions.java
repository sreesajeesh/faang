package streams.partone;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamQuestions {

    public static void main(String[] args) {

        //Print sum of all numbers
        List<Integer> intList = Arrays.asList(2,4,6,8,10);

        Integer sum = intList.stream()
                .reduce(Integer::sum).get();

        //Find Average
        Double average = intList.stream().mapToInt(e->e)
                .average().getAsDouble();

        //Number Square Average
        Double sqrAverage = intList.stream()
                .mapToInt(e -> e*e)
                .filter(e-> e > 36)
                .average().getAsDouble();
        System.out.println(sqrAverage);

        intList = Arrays.asList(1,2,3,4,5,6,7,8);

        System.out.println(intList.stream().filter(e-> e%2 == 0).collect(Collectors.toList()));

        //Print Numbers Starts With Prefix 2 using Streams
        intList = Arrays.asList(21,12,33,24,55,26,87,28);
        System.out.println(intList.stream()
                .map(Object::toString)
                //.filter(e -> e.charAt(0) == '2')
                        .filter(e-> e.startsWith("2"))
                        .map(Integer::valueOf)
                .collect(Collectors.toList()));

        // Print Duplicate Numbers using Streams
        intList = Arrays.asList(21,12,21,24,55,26,55,28);
        List<Integer> finalIntList = intList;
        System.out.println(
                intList.stream()
                .filter(e-> Collections.frequency(finalIntList, e) > 1)
                        .collect(Collectors.toSet()));

        System.out.println(intList.stream()
                .filter(e-> Collections.frequency(finalIntList, e) == 1).collect(Collectors.toSet()));
        System.out.println(new HashSet<>(intList));

        //Find Max and Min Numbers using Streams
        System.out.println(intList.stream()
                .max(Integer::compareTo).get());
        System.out.println(intList.stream()
                .min(Integer::compareTo).get());

        //Sort Numbers (ASC/DESC) using Streams

        System.out.println(intList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

        System.out.println(intList.stream().sorted().collect(Collectors.toList()));

        //Get/ignore first 5 numbers using Limit & Skip in Streams
        System.out.println(intList.stream().skip(3).collect(Collectors.toList()));
        System.out.println(intList.stream().limit(3).collect(Collectors.toList()));

        //Get Second Highest/Lowest Number using Streams
        intList = Arrays.asList(21,12,27,24,59,26,55,28);
        System.out.println(intList.stream().sorted(Collections.reverseOrder()).skip(1).limit(1).collect(Collectors.toList()));
        System.out.println(intList.stream().sorted().skip(1).limit(1).collect(Collectors.toList()));
    }
}
