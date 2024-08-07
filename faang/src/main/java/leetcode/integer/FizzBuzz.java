package leetcode.integer;

import java.util.Arrays;

public class FizzBuzz {

    public static void main(String[] args) {
        String[] strings = getFizzBuzz(20);
        System.out.println(Arrays.stream(strings).toList());
    }

    public static String[] getFizzBuzz(int n){
        String[] strings = new String[n+1];
        strings[0] = "0";

        for(int i = 1; i <= n; i++){
            if (i%3 == 0 && i%5 == 0){
                strings[i] = "FizzBuzz";
            } else if (i%3 == 0) {
                strings[i] = "Fizz";
            }else if(i%5 == 0){
                strings[i] = "Buzz";
            } else {
                strings[i] = "" + i;
            }
        }
        return strings;
    }

}


