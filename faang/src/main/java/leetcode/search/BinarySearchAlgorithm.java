package leetcode.search;

import java.util.Arrays;

public class BinarySearchAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        System.out.println(inBuildBinarySearch(arr, 14));
    }

    public static int binarySearch(int[] arr, int n){
        int right = arr.length -1;
        int left = 0;
        int middle = -1;

        while(left <= right){
            middle = (left + right)/2;
            if(n > arr[middle]){
                left = middle+1;
            } else if (n < arr[middle]){
                right = middle-1;
            } else {
                return middle;
            }
            middle = -1;
        }
        return middle;
    }

    public static int inBuildBinarySearch(int[] arr, int n){
        int result = Arrays.binarySearch(arr, n);
        if(result < 0)
            return -1;
        return result;
    }
}
