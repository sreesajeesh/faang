package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamRotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int i, int j){
        for(; i < j; ++i, --j ){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
