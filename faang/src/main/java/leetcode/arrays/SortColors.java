package leetcode.arrays;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = new int[]{2,0,1,0,1,0};
        System.out.println(Arrays.toString(sortColors(colors)));
    }

    public static int[] sortColors(int[] nums){
        int left = 0, middle = 0;
        int right = nums.length - 1;

        while (middle <= right){
            if(nums[middle] == 0){
                swap(nums, left, middle);
                middle++;
                left++;
            } else if(nums[middle] == 1){
                middle++;
            } else {
                swap(nums, right, middle);
                right--;
            }
        }
        return nums;
    }

    private static void swap(int[] colors, int pos, int middle){
        int temp = colors[middle];
        colors[middle] = colors[pos];
        colors[pos] = temp;
    }
}
