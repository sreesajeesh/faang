package leetcode.integer;

import java.util.Arrays;

public class ProductOfArrays {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,4};
        System.out.println(Arrays.toString(getProductArray(arr)));
        System.out.println(Arrays.toString(getProductArray2(arr)));
    }

    public static int[] getProductArray(int[] nums){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i - 1] * left[i-1];
            right[nums.length - 1 - i] = nums[nums.length - i] * right[nums.length - i];
        }
        for(int i = 0; i < nums.length; i++){
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    public static int[] getProductArray2(int[] nums){
        int[] left = new int[nums.length];
        int[] answer = new int[nums.length];
        left[0] = 1;
        int right = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i - 1] * left[i-1];
        }
        for(int i = nums.length - 1; i >= 0; i-- ){
            answer[i] = left[i] * right;
            right = right * nums[i];
        }
        return answer;
    }
}
