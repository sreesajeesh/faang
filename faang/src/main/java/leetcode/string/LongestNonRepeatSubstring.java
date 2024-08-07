package leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LongestNonRepeatSubstring {

    public static void main(String[] args) {
        System.out.println(getLongestSubstring("pwwkew"));
    }

    public static int getLongestSubstring(String s){
        //Have map with character and integer indicates index of the character in the string.
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            if(!charMap.containsKey(s.charAt(right))){
                //if new character then add it to the map.
                charMap.put(s.charAt(right), right);
            } else {
                // if repeated character, see that left pointer is pointing to the highest index
                // update character map with new index
                left = Math.max(left, charMap.get(s.charAt(right)) +1);
                charMap.put(s.charAt(right),right);
            }
            //check max of max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
