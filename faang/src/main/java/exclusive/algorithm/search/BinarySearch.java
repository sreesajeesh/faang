package exclusive.algorithm.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //System.out.println(binarySearchRecursive(arr, 3, 0, arr.length-1));
        System.out.println(binarySearchInBuild(arr, 11));
    }

    public static int binarySearch(int[] arr, int target, int left, int right){
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target) {
                return target;
            }else if(target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int left, int right){
        if(right >= left){
            int mid = (left + right)/2;
            if(arr[mid] == target) {
                return target;
            }
            if(target < arr[mid]) {
                right = mid + 1;
                return binarySearchRecursive(arr, target, left, right);
            }
            if (target > arr[mid]) {
                left = mid - 1;
                return binarySearchRecursive(arr, target, left, right);
            }
        }
        return -1;
    }

    public static int binarySearchInBuild(int[] arr, int target){
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, target);
    }
}
