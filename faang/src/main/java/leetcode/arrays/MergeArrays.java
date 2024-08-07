package leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeArrays {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{1,2,3};
        System.out.println(Arrays.toString(mergeArrayByStream(a,b)));
        System.out.println(getDistinct(a, b));
    }

    public static int[] mergeArrayByStream(int[] a, int[] b){
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }

    public static int getDistinct(int[] a, int[] b){
//        int[] c = mergeArrayByStream(a, b);
//        return Arrays.stream(c).boxed().collect(Collectors.toSet()).size();
        return Arrays.stream(IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .toArray())
                .boxed()
                .collect(Collectors.toSet())
                .size();
    }
}
