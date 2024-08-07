package leetcode.arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextPermutation(arr)));
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }

    private static void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static int[] nextPermutation(int[] nums){
        boolean flag = false;
        int k = nums.length - 2;
        System.out.println(k);
        while(k >= 0 && nums[k] >= nums[k + 1]){
            k--;
        }
        System.out.println(k);
        if(k >= 0){
            int j = nums.length - 1;
            while (nums[k] >= nums[j]){
                j--;
            }
            System.out.println("k = " + k + " j = " + j);
            swap(nums,k,j);
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("After Swapping");
        System.out.println(Arrays.toString(nums));
        reverse(nums, k+ 1, nums.length -1);
        return nums;
    }
}
/*for (int i = nums.length -1; i > 0; i--) {
            if(nums[i-1] < nums[i] ){
                int temp = nums[i];
                nums[i] =  nums[i -1];
                nums[i-1] = temp;
                flag = true;
                Arrays.sort(nums,i, nums.length);
                break;
            } else {
                //if(flag)
                    Arrays.sort(nums,i -1, i+1);
            }
        }
        if(!flag)
            Arrays.sort(nums);*/