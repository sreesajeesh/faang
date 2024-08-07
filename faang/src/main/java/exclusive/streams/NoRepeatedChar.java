package exclusive.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NoRepeatedChar {

    public static void main(String[] args) {
        String str1 = "independent";
        noRepeat(str1);

    }

    public static void noRepeat(String str){
        Map<Character, Long> charMap = new LinkedHashMap<>();
        List<Character> charList = new ArrayList<>();
        /*char[] chars = str.toCharArray();
        for(Character ch : chars){
            if(!charMap.containsKey(ch)){
                charMap.put(ch, 1);
            } else {
                int value = charMap.get(ch);
                charMap.put(ch, value + 1);
            }
        }*/

        charMap = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        charList = charMap.entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(charList);
                //.forEach(System.out::println);
        /*for(Character ch : charMap.keySet()){
            if(charMap.get(ch) == 1)
                charList.add(ch);
        }
        System.out.println(charList);*/
    }


}
