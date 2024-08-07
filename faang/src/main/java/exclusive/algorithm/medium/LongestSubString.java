package exclusive.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        String string = "abcabcaa";
        //System.out.println(checkLongestByBrute(string));
        System.out.println(checkLongestByOptimum(string));
    }

    public static int checkLongestByBrute(String str){
        if (str.length() <= 1)
            return str.length();
        int longest = 0;
        for(int left = 0; left < str.length(); left++){
            Map<Character, Boolean> seenChars = new HashMap<>();
            int currentLength = 0;
            for(int right = left; right < str.length(); right++){
                char chars = str.charAt(right);
                if(!seenChars.containsKey(chars)){
                    currentLength++;
                    seenChars.put(chars, Boolean.TRUE);
                    longest = Math.max(longest, currentLength);
                } else {
                    break;
                }
            }
        }
        return longest;
    }

    //use the sliding window to represent  the current substring
    //The size of the window will change based on the addition of new characters and characters
    //that already seen before.
    //Our seen character hashmap keep track of the characters we have seen and their index.
//    abcabcaa
//            previousindex = -1;
//    left = 0; maxlength = 0;
//    right =0
//    current char = a;
//    seenchars does not contain a as seenchar is empty
//    check previous index is >= left so no
//    so put the current character and its index as a, 0
//    check maxlength 0-0 + 1 so maxlength =1
//    right = 1
//    current char = b
//    seenchar does not contains b so previous index is not changed
//    check previous index is >= left so value of left is not changed
//    so put the current character and its index as b, 1
//    check maxlength 1-0 + 1 so maxlength =2
//    right = 2
//    current char = c
//    seenchar does not contains c so previous index is not changed
//    check previous index is >= left so value of left is not changed
//    so put the current character and its index as c, 2
//    check maxlength 2-0 + 1 so maxlength =3
//    right = 3
//    current char = a
//    seenchar does contains a so previous index is 0
//    check previous index is >= left so value of left is changed to 1 (left value was 0)
//    so put the current character and its index as a, 3
//    check maxlength 3-1 + 1 so maxlength =3
//    right = 4
//    current char = b
//    seenchar does contains b so previous index is 1
//    check previous index is >= left so value of left is changed to 2 (left value was 0)
//    so put the current character and its index as b, 4
//    check maxlength 4-2 + 1 so maxlength =3
//    right = 5
//    current char = c
//    seenchar does contains c so previous index is 2
//    check previous index is >= left so value of left is changed to 3 (left value was 0)
//    so put the current character and its index as c, 5
//    check maxlength 5-3 + 1 so maxlength =3
//    right = 6
//    current char = a
//    seenchar does contains a so previous index is 3
//    check previous index is >= left so value of left is changed to 4 (left value was 0)
//    so put the current character and its index as a, 6
//    check maxlength 6-4 + 1 so maxlength =3
//    right = 7
//    current char = a
//    seenchar does contains a so previous index is 6
//    check previous index is >= left so value of left is changed to 7 (left value was 0)
//    so put the current character and its index as a, 7
//    check maxlength 7-7 + 1 so maxlength =3
    public static int checkLongestByOptimum(String str){
        if (str.length() <= 1)
            return str.length();
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> seenChars = new HashMap<>();
        //seenChars.put(str.charAt(0), 0);
        int previousIndex = -1;
        //abcabcaa
        for(int right = 0; right < str.length(); right++){
            char currentChar = str.charAt(right);
            System.out.println("right : " + right);
            System.out.println("left : " + left);
            if(seenChars.containsKey(str.charAt(right))){
                previousIndex = seenChars.get(str.charAt(right));
                System.out.println("previousIndex : " + previousIndex);
            }
            if(previousIndex >= left){
                left = previousIndex + 1;
                System.out.println("left in if condition : " + left);
            }
            seenChars.put(currentChar, right);
            System.out.println("maxlength : " + maxLength);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
