package exclusive.algorithm.easy;

public class Palindrome {

    public static void main(String[] args) {
        //String str = "A man, a plan, a  canal: Panama";
        String str = "abeccdba";
        System.out.println(checkAlmostPalindrome(str));

    }

    public static boolean checkPalindrome(String str) {
        String pStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0; i < pStr.length() / 2; i++) {
            if (pStr.charAt(i) != pStr.charAt(pStr.length() - i - 1)) {
                return false;
            }
        }

        System.out.println(pStr);
        return true;
    }

    public static boolean checkAlmostPalindrome(String str) {
        String pStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = pStr.length() - 1;
        while (left < right) {
            if (pStr.charAt(left) != pStr.charAt(right)) {
                return validPalindrome(pStr, left +1, right) || validPalindrome(pStr, left, right -1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean validPalindrome(String str, int left, int right){
        while (left < right) {
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}