package leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingPositive {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,2, -1,1};
        System.out.println(missingPositiveStreams(arr));
    }

    public static int missingPositiveStreams(int[] nums){
        Set<Integer> integerList = Arrays.stream(nums).boxed()
                .collect(Collectors.toSet());
        for (int i = 1; i < nums.length + 2; i++) {
            if(!integerList.contains(i))
                return i;
        }
        return nums.length + 1;
    }

    public static int missingPositive(int[] nums){
        //pre process the array with negative value and 0 set to length of array + 1
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0)
                nums[i] = nums.length + 1;
        }
        System.out.println(Arrays.toString(nums));
        //marking the indices with array of that index is greater than 0
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if(index < nums.length) {
                if (nums[index] > 0) {
                    nums[index] *= -1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        // traverse the array to find first positive element and return the index + 1
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return nums.length + 1;
    }
}
