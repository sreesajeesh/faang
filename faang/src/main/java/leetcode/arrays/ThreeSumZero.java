package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,0,0,2,2};
        System.out.println(getThreeSum(arr));
    }

    public static List<List<Integer>> getThreeSum(int[] nums) {
        List<List<Integer>> zeroSums = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int target = 0 - nums[i];
                while (left < right) {
                    if (target == nums[left] + nums[right]) {
                        List<Integer> zeroList = new ArrayList<>();
                        zeroList.add(nums[i]);
                        zeroList.add(nums[left]);
                        zeroList.add(nums[right]);
                        zeroSums.add(zeroList);
                        while (left < nums.length - 1 && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while (right > 0 && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    } else if(target < nums[left] + nums[right]){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return zeroSums;
    }
}
