package JavaTechie;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrence {

    public static void main(String[] args) {
        System.out.println(getOccurrence("ilovejavatechie"));
        System.out.println(getDuplicates("ilovejavatechie"));
        System.out.println(getFirstNonRepeatChar("ilovejavatechie"));
        int[] arr = new int[]{5,9,11,2,8,21,1};
        System.out.println(secondHighestNumber(arr));
    }

    public static Map<Character, Long> getOccurrence(String str){

        return str.chars()
                .mapToObj((c) -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public static List<Character> getDuplicates(String str){
        return str.chars()
                .mapToObj((c) -> (char)c )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static char getFirstNonRepeatChar(String str){
        return str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    public static int secondHighestNumber(int[] nums){
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
    }

    public static String getLongestString(String[] strArr){
        return Arrays.stream(strArr)
                .reduce((word1, word2) -> (word1.length() > word2.length()? word1:word2))
                .get();
    }

    public static List<Integer> getIntegerStartWithOne(int[] arr){
        return Arrays.stream(arr)
                .boxed()
                .map((i) -> i + "")
                .filter((k) -> k.startsWith("1"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
