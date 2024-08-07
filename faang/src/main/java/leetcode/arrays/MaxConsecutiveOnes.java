package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,0,1,1,1};
        System.out.println(maxOnes(arr));
    }

    public static int maxOnes(int[] nums){
        int max = 0;
        int finalMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                max++;
                finalMax = Math.max(finalMax, max);
            } else {
                max = 0;
            }
        }
        return finalMax;
    }
}
