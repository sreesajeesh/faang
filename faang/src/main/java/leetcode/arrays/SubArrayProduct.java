package leetcode.arrays;


import java.util.HashMap;

import java.util.Map;

public class SubArrayProduct {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println(subArrayProduct5(arr, 12));
    }

    public static int subArrayProduct5(int[] nums, int k){
        int left = 0;
        int count = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k){
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static int subArrayProduct(int[] nums, int k){
        Map<Integer, Integer> subMap = new HashMap<>();
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product = nums[i];
            if(product < k){
                addMap(subMap, product, k);
            }
            for (int j = i + 1; j < nums.length; j++) {
                product  *= nums[j];
                if(product < k ){
                    addMap(subMap, product, k);
                } else {
                    break;
                }
            }
        }
        return subMap.values().stream().mapToInt(a->a).sum();
    }

    public static int subArrayProduct2(int[] nums, int k){
        int product = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            product = nums[i];
            if(product < k){
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] >= k)
                    break;
                product  *= nums[j];
                if(product < k ){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private static void addMap(Map<Integer, Integer> subMap, int product, int k){
        if(!subMap.containsKey(product)){
            subMap.put(product, 1);
        } else {
            int value = subMap.get(product);
            subMap.put(product, value + 1);
        }
    }
}
