package leetcode.search;

public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,9,0,1,2,3};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int min = arr[0];

        while (left <= right){
            int middle = left + (right - left)/2;
            if(arr[middle] > arr[middle + 1])
                return arr[middle + 1];
            if(arr[middle - 1] > arr[middle])
                return arr[middle];
            if(arr[left] < arr[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }
}
