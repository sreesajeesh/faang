package exclusive.algorithm.easy;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PalindromeStream {

    public static void main(String[] args) {
        checkPalindrome("abcaa");
    }

    public static void checkPalindrome(String str){
        StringBuilder reverse = new StringBuilder(str);
        reverse.reverse();
        System.out.println(reverse.toString().equals(str));
    }

    public static void checkPalindromeStream(String str){
        System.out.println(IntStream.range(0, str.length()/2)
                .noneMatch(i-> str.charAt(i) != str.charAt(str.length()-i-1))
        );
    }
}
