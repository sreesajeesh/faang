package leetcode.arrays;

import java.util.Arrays;

public class TwoSumIndexSorted {

    public static void main(String[] args) {
        int[] arr = new int[]{-10,-8,-2,1,2,5,6};
        System.out.println(Arrays.toString(getSumIndex(arr, 0)));
    }

    public static int[] getSumIndex(int[] numbers, int target){
        int left = 0;
        int right = 1;
        int[] arr = new int[2];

        while(right < numbers.length && left < right){
            if(numbers[right] + numbers[left] == target){
                arr[0] = left + 1;
                arr[1] = right + 1;
                break;
            } else if(numbers[right] + numbers[left] < target){
                if(right == numbers.length - 1){
                    left++;
                    right = left + 1;
                } else
                    right++;
            } else {
                left++;
                right = left + 1;
            }
        }
        return arr;
    }

    public static int[] getSumIndex2(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        int[] arr = new int[2];

        while(left < right){
            if(numbers[right] + numbers[left] == target){
                arr[0] = left + 1;
                arr[1] = right + 1;
                break;
            } else if(numbers[right] + numbers[left] > target){
                right--;
            } else {
                left++;
            }
        }
        return arr;
    }

}
