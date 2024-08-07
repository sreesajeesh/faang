package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseBest(" The   sky is blue "));
    }

    public static String reverseWords(String s){
        Map<Integer, String> stringMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = Arrays.asList(s.split(" "));
        int i = 0;
        for(String str : stringList){
            if(!str.isBlank()) {
                stringMap.put(i++, str.trim());
            }
        }
        System.out.println(stringMap);
        for(int j = stringMap.size() -1; j >= 0; j--){
            stringBuilder.append(stringMap.get(j)).append(" ");
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString().trim();
    }

    public static String reverseBest(String s){
        String reverseString = new StringBuilder(s).reverse().toString();
        List<String> stringList = Arrays.asList(reverseString.split(" "));
        StringBuilder str1 = new StringBuilder();
        for(String string : stringList){
            if(!string.isBlank()){
                string = string.trim();
                str1.append(new StringBuilder(string).reverse()).append(" ");
            }
        }
        return str1.toString().trim();
    }
}