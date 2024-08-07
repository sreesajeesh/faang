package leetcode.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        rotate(arr, 3);
    }

    public static void rotate(int[] nums, int k){
        int count;
        if(k > nums.length - 1)
            count = k%(nums.length - 1);
        else
            count = k;
        int i;
        while (count > 0) {
            int temp = nums[nums.length - 1];
            for (i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[i] = temp;
            System.out.println(Arrays.toString(nums));
            count--;
        }
    }
}
