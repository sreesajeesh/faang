package leetcode.arrays;

public class IsSubsequence {

    public static void main(String[] args) {

        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence2(s, t));
    }

    public static boolean isSubsequence(String s, String t){
        if(s.length() == t.length()){
            return s.equals(t);
        }
        if(s.isEmpty())
            return true;
        int sIndex = 0;
        int right = 0;
        String temp = t;
        while (sIndex < s.length()){
            if(right >= t.length())
                break;
            if(temp.charAt(right) != s.charAt(sIndex)){
                temp = temp.replaceFirst(temp.charAt(right) + "", "=");
            } else {
                if(sIndex == s.length() -1){
                    temp = temp.substring(0, right + 1);
                }
                sIndex++;
            }
            right++;
        }
        System.out.println(temp);
        temp = temp.replaceAll("=", "");
        return s.equals(temp);
    }

    public static boolean isSubsequence2(String s, String t) {
        if (s.length() == t.length()) {
            return s.equals(t);
        }
        if (s.isEmpty())
            return true;
        int sIndex = 0;
        int tIndex = 0;

        while(sIndex < s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                if(sIndex == s.length()-1)
                    return true;
                sIndex++;
            } else {
                if(tIndex == t.length() -1)
                    return false;
            }
            tIndex++;
        }
        return false;
    }

    public static boolean isSubsequence3(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}
