package exclusive.dojo;

public class OneAwayString {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfdfca";
        checkOneAway(s1, s2);

    }

    public static void checkOneAway(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1){
            System.out.println("Not Possible");
            return;
        }
        if(s1.length() == s2.length()){
            int count = 0;
            int i = 0;
            while(i < s1.length()){
                if(s1.charAt(i) == s2.charAt(i)){
                    i++;
                    continue;
                } else {
                    count++;
                    i++;
                    if(count > 1) {
                        System.out.println("No one way replaceable");
                        return;
                    }
                }
            }
            if(count == 1)
                System.out.println("One way replaceable");
        }
    }
}
