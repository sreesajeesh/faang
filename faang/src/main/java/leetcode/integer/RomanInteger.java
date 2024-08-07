package leetcode.integer;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {

    public static void main(String[] args) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        System.out.println(getInteger("CMXCVIII", roman));
    }

    public static int getInteger(String romanStr, Map<Character, Integer> roman){
        int i = 0;
        int sum = 0;
        while (i < romanStr.length()){
            if(i + 1 != romanStr.length()){
                if(roman.get(romanStr.charAt(i)) <  roman.get(romanStr.charAt(i+1))){
                    sum = sum - roman.get(romanStr.charAt(i));
                } else {
                    sum = sum + roman.get(romanStr.charAt(i));
                }
            }
            i++;
        }
        sum = sum + roman.get(romanStr.charAt(romanStr.length() - 1));
        return sum;
    }
}
