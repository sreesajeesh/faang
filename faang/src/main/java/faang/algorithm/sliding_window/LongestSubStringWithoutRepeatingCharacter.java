package faang.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        String word = "pwxyzwkewz";
        System.out.println(getUniqueCharacterSubstring(word));
    }

    public static int findLengthOfLongestSubString(String word){
        Map<Character, Boolean> charMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int lengthOfLongestString = 0;
        char[] ch = word.toCharArray();

        for(char character : ch){
            if(charMap.size() == 0) {
                charMap.put(character, true);
                lengthOfLongestString = Math.max(lengthOfLongestString, end - start + 1);
            } else {
                if (charMap.containsKey(character) && !charMap.get(character)) {
                    charMap.put(character, true);
                    lengthOfLongestString = Math.max(lengthOfLongestString, end - start + 1);
                } else {
                    //for (Character key : charMap.keySet()) {
                    int count = 0;
                    while(count < charMap.size()) {
                        charMap.put(ch[start], false);
                        start++;
                        count++;
                    }
                    charMap.put(character, true);
                }
            }

        }
        return lengthOfLongestString;
    }


    public static int getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output.length();
    }
}
