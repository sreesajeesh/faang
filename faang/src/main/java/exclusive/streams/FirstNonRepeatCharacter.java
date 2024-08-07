package exclusive.streams;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FirstNonRepeatCharacter {

    public static void main(String[] args) {
        firstNonRepeat("sajeeshkumar");
    }

    public static void firstNonRepeat(String str){
        Map<Character, Long> charMap = str.chars()
                .mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
        Optional<Character> optional = charMap.entrySet()
                .stream()
                .filter(map -> map.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        optional.ifPresent(System.out::println);

        Optional<Character> optional1 = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity()
                        , LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map->map.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        if(optional.isPresent())
            System.out.println(optional1.get());

        Optional<Character> optional2 = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        Optional<Character> optional3 = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map->map.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
