package exclusive.algorithm.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class MaxMin {

    public static void main(String[] args) {
        int[] arr = {23,34,12,78,4,3};
        System.out.println(findDifference(arr));

    }

    public static int findDifference(int[] arr){
        Arrays.sort(arr);
        return Math.max(arr[arr.length -1] + arr[0], arr[arr.length-2] + arr[1]);
    }
}
