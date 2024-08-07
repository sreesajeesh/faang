package javaeight;

public class RotateStringEquality {

    public static void main(String[] args) {
        System.out.println(rotateEquality("india", "diain"));
    }

    public static boolean rotateEquality(String s1, String s2){
        if(s1.length() !
                = s2.length())
            return false;

        int count = 0;

        while(count < s2.length()/2){
            s1 = s1.substring(1, s2.length()) + s1.charAt(0);
            System.out.println(s1);
            if(s2.equals(s1))
                return true;
            count++;
        }
        return false;
    }
}
