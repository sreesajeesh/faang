package leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5, 3,4,5};
        System.out.println(findDuplicate(nums));
    }

    public static boolean findDuplicate(int[] nums){
        Map<Integer, Integer> dupMap = new HashMap<>();
        for(int num : nums){
            if(!dupMap.containsKey(num)){
                dupMap.put(num, 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean findDuplicate2(int[] nums){
        Set<Integer> dupSet = new HashSet<>();
        for(int num : nums){
            if(dupSet.contains(num)){
                return true;
            } else {
                dupSet.add(num);
            }
        }
        return false;
    }
}
