package leetcode.search;

public class BinarySearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,9,0,1,2,3};
        System.out.println(getIndex(arr, 2));
    }

    public static int getIndex(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int middle = -1;

        while(left <= right){
            middle = left + (right-left)/2;
            if(target == arr[middle]){
                return middle;
            }
            if(arr[left] <= arr[middle]){
                if(arr[left] <= target && target < arr[middle]){
                    right = middle - 1;
                } else {
                    left = middle  + 1;
                }
            } else {
                if(arr[middle] < target && target <= arr[right]){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
