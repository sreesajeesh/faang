package javaeight;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTemperature {

    public static void main(String[] args) {
        List<Double> temperatures = Arrays.asList(98.4, 100.2, 100.2, 87.9, 102.8, 102.8);
        System.out.println("No of temperatures > 100 : "
        + temperatures.stream()
                .filter(temp -> temp > 100)
                        .distinct()
                .count());

        /*Stream.iterate(2, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);*/

        Stream<String> stream = Stream.of("car", "bus","train", "aeroplane");

        int length = stream
                .parallel()
                .reduce(0,
                (n, str) -> n + str.length(),
                Integer::sum);

        //System.out.println(length);

        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
        //System.out.println(word);

        String s = Stream.of("cake", "biscuit", "apple tart")
                .collect(Collectors.joining(", "));

        String s1 = String.join(", ", "cake", "biscut", "apple tart");

        Double avg = Stream.of("cake", "biscuit", "apple tart")
                .collect(Collectors.averagingInt(String::length));

        /*
            Collecting into Map
            Two function required
            first function tells collector how to create key
            second function tells collector how to create value
         */

        Map<String, Integer> strMap = Stream.of("cake", "biscuit", "apple tart")
                .collect(Collectors.toMap(l -> l, String::length));
        //System.out.println(strMap);

        Map<Integer, String> intMap = Stream.of("cake", "biscuit", "tart")
                .collect(Collectors.toMap(String::length,
                        k -> k,
                        (s3, s2) -> s3 + ", " + s2));
        //System.out.println(intMap);

        TreeMap<String, Integer> strTreeMap = Stream.of("cake", "biscuit", "tart", "cake")
                .collect(Collectors.toMap(ss -> ss,
                        String::length,
                        Integer::sum,
                        TreeMap::new));
        //System.out.println(strTreeMap);

        //Collector.groupingBy

        Map<Integer, List<String>> mapList = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter")
                .collect(Collectors.groupingBy(String::length));
        //System.out.println(mapList);

        //Collector.groupingBy
        Map<Integer, Set<String>> mapSet = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(mapSet);

        TreeMap<Integer, List<String>> mapTree = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter")
                .collect(Collectors.groupingBy(String::length,
                        TreeMap::new,
                        Collectors.toList()));
        System.out.println(mapTree);

        //Collectors.partitioningBy returns Map<Boolean, List>
        Map<Boolean, List<String>> mapBoolean = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter")
                .collect(Collectors.partitioningBy(ss -> ss.startsWith("T")));
        System.out.println(mapBoolean);

        Map<Boolean, Set<String >> mapSetBoolean = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Peter")
                .collect(Collectors.partitioningBy(ss -> ss.length() > 3, Collectors.toSet()));
        System.out.println(mapSetBoolean);

        //Intermediate operations filter examples


        Stream.of("galway", "mayo", "rosecommon")
                .filter(sk -> sk.length() > 5)
                .forEach(System.out::println);

        //distinct intermediate operation
        Stream.of("eagle", "eagle", "EAGLE")
                //.peek(s2 -> System.out.print(" 1." + s2))
                .distinct()
                .forEach(System.out::println);

        IntSummaryStatistics iss = IntStream.of(1,2,3,4)
                .summaryStatistics();
        
        Optional<String> optSK = howToDealWithNull("SK");
        optSK.ifPresent(System.out::println);
        Optional<String> optNull = howToDealWithNull(null);
        System.out.println(optNull.orElseGet(() -> "Empty Optional"));

    }

    public static Optional<String> howToDealWithNull(String param){
        return Optional.ofNullable(param);
    }
}
