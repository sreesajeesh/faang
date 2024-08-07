package leetcode.integer;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(123421));

    }

    public static boolean isPalindrome(int x){
        // x is negative or x is not zero and end with zero
        if(x < 0)
            return false;
        if(x != 0 && x%10 == 0)
            return false;
        int reverse = 0;
        while(x > reverse){
            int lastDigit = x%10;
            reverse = reverse * 10 + lastDigit;
            x = x/10;
        }
        return (x == reverse) || (x == reverse/10);
    }
}
