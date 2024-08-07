package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayZero {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,-1,1,1};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr){
        Map<Integer, Integer> indexMap = new HashMap<>();
        int sum = 0;
        int length = 0;
        if(arr.length == 1 && arr[0] == 0)
            return 1;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if(sum == 0){
                length = i + 1;
            } else if(!indexMap.containsKey(sum)){
                indexMap.put(sum, i);
            } else {
                length = Math.max(length, i - indexMap.get(sum));
            }
        }
        return length;
    }
}
