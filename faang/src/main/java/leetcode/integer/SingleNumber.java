package leetcode.integer;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {

        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(getSingleNumberXOR(arr));

    }

    public static int getSingleNumberSet(int[] arr){
        Set<Integer> integerSet = new HashSet<>();
        for (int j : arr) {
            if (integerSet.contains(j)) {
                integerSet.remove(j);
            } else {
                integerSet.add(j);
            }
        }

        System.out.println(integerSet);

        return integerSet.stream().findFirst().get();
    }

    public static int getSingleNumberXOR(int[] arr){
        int number = 0;
        for (int j : arr) {
            number = number ^ j;
        }
        return number;
    }
}
