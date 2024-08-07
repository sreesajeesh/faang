package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {

    public static void main(String[] args) {
        String ransom = "abbc";
        String magazine = "aabbcc";
        System.out.println(getRansom4(ransom, magazine));
    }

    public static boolean getRansom(String ransomNote, String magazine){
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            if(!ransomMap.containsKey(ransomNote.charAt(i))){
                ransomMap.put(ransomNote.charAt(i), 1);
            } else {
                int value = ransomMap.get(ransomNote.charAt(i));
                ransomMap.put(ransomNote.charAt(i), value + 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            if(!magazineMap.containsKey(magazine.charAt(i))){
                magazineMap.put(magazine.charAt(i), 1);
            } else {
                int value = magazineMap.get(magazine.charAt(i));
                magazineMap.put(magazine.charAt(i), value + 1);
            }
        }
        for(Character ch : ransomMap.keySet()){
            if(!magazineMap.containsKey(ch)){
                return false;
            } else if(ransomMap.get(ch) > magazineMap.get(ch)){
                return false;
            }
        }
        return true;
    }

    public static boolean getRansom2(String ransomNote, String magazine){
        Map<Character, Integer> magazineMap = new HashMap<>();
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {
            if(!magazineMap.containsKey(magazine.charAt(i))){
                magazineMap.put(magazine.charAt(i), 1);
            } else {
                int value = magazineMap.get(magazine.charAt(i));
                magazineMap.put(magazine.charAt(i), value + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(!magazineMap.containsKey(ransomNote.charAt(i))){
                return false;
            } else if(magazineMap.get(ransomNote.charAt(i)) == 0){
                return false;
            } else {
                int value = magazineMap.get(ransomNote.charAt(i));
                magazineMap.put(ransomNote.charAt(i), value - 1);
            }
        }
        return true;
    }

    public static boolean getRansom3(String ransomNote, String magazine){
        for (int i = 0; i < ransomNote.length(); i++) {
            if(magazine.contains(String.valueOf(ransomNote.charAt(i)))){
                magazine = magazine.replaceFirst(ransomNote.charAt(i) + "", "");
            } else {
                return false;
            }

        }
        return true;
    }

    public static boolean getRansom4(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            frequency[ch - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if(frequency[ch - 'a'] == 0) return false;
            frequency[ch - 'a']--;
        }
        return true;
    }
}
