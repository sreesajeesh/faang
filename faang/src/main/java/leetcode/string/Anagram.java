package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Anagram {

    public static void main(String[] args) {

        System.out.println(checkAnagramArray("sajeesh", "hseejas"));

    }

    public static boolean checkAnagram(String s, String t){
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        if(s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); i++){
            first.put(s.charAt(i), first.getOrDefault(s.charAt(i), 0) + 1);
            second.put(t.charAt(i), second.getOrDefault(t.charAt(i), 0) + 1);
        }
        if(first.size() != second.size())
            return false;
        for(Character chars : first.keySet()){
            if(!Objects.equals(first.get(chars), second.get(chars)))
                return false;
        }
        return true;
    }

    public static boolean checkAnagramOptimum(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        int i = s1.length() - 1;
        while (i > 0){
            char c = s1.charAt(i);
            s2 = s2.replaceFirst(c + "",  "");
            s1 = s1.replaceFirst(c + "", "");

            i--;
        }
        return s1.equals(s2);
    }

    public static boolean checkAnagramArray(String s, String t){
        int[] counter = new int[26];
        if(s.length() != t.length())
            return false;
        for (int i = 0; i < s.length() ; i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
            if(counter[t.charAt(i) - 'a'] < 0)
                return false;
        }

        for(int count : counter){
            if(count != 0)
                return false;
        }
        return true;
    }
}
