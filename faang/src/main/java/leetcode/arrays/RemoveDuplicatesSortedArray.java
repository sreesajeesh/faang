package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,4,4};
        System.out.println(removeDuplicates3(arr));
    }

    public static int removeDuplicates(int[] nums){
        return (int) Arrays.stream(nums).boxed()
                .distinct()
                .count();
    }

    public static int removeDuplicates2(int[] nums){
        Set<Integer> treeSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        nums = treeSet.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums));
        return treeSet.size();
    }

    public static int removeDuplicates3(int[] nums){
        int left = 0;
        int right = 1;
        while (right < nums.length){
            if(nums[left] == nums[right]){
                right++;
            } else {
                nums[++left] = nums[right];
            }
        }
        return left  + 1;
    }
}
