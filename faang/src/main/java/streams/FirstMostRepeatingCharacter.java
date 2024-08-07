package streams;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstMostRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(getFirstMostRepeating1("bajeeshhhhekumar"));
    }

    public static Character getFirstMostRepeating(String str){
        return str.chars().mapToObj(a ->(char)a)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(e -> Math.toIntExact(e.getValue())))
                .map(Map.Entry::getKey)
                .get();

    }

    public static Character getFirstMostRepeating1(String str){
        return str.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
