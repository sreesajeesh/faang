package leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2};
        System.out.println(Arrays.toString(moveZeroEfficient(arr)));
    }

    public static int[] moveZeroesToEnd(int[] arr){
        Queue<Integer> queue = new ArrayDeque<>();
        for (int j : arr) {
            if (j != 0) {
                queue.add(j);
            }
        }
        int queueLength = queue.size();
        for(int i = 0; i < arr.length; i++){
            if(i< queueLength)
                arr[i] = queue.poll();
            else
                arr[i] = 0;
        }
//        for(int i = arr.length - queueLength; i < arr.length; i++ ){
//            arr[i] = 0;
//        }
        return arr;
    }

    public static int[] moveZeroEfficient(int[] nums){
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < nums.length){
            nums[left] = 0;
            left++;
        }
        return nums;
    }
}
