package leetcode.string;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacabe"));
    }

    public static String longestPalindrome(String s){
        int start = 0, end = 0;
        for(int i =0; i < s.length(); i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);

            System.out.println("Odd = " + odd + "  Even = " + even);
            System.out.println("Start = " + start + " End = " + end);
            int len = Math.max(odd, even);

            if(len > end - start){
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        System.out.println("left = " + left + " right = " + right +  " right -left -1 = " + (right-left-1));
        return right-left-1;
    }
}
