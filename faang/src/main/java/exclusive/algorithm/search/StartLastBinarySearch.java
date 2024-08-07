package exclusive.algorithm.search;

public class StartLastBinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,3,5,5,5,8,9};
        firstLastIndex(arr, 5);
    }

    public static void firstLastIndex(int[] arr, int target){
        if(arr.length == 0) return;
        int firstPost = binarySearch(arr, target, 0, arr.length-1);
        if(firstPost == -1) return;
        int startPos = firstPost;
        int endPos = firstPost;
        int tempLeft = -1;
        int tempRight = -1;
        while (startPos != -1){
            tempLeft = startPos;
            startPos = binarySearch(arr, target, 0,startPos-1);
        }
        startPos = tempLeft;
        while (endPos != -1){
            tempRight = endPos;
            endPos = binarySearch(arr, target, endPos+1, arr.length-1);
        }
        endPos = tempRight;
        System.out.println(startPos + ", " + endPos);
    }

    public static int binarySearch(int[] arr, int target, int left, int right){
        while(left <= right){
            int mid = (int)Math.floor((double) (left + right) /2);
            if(arr[mid] == target) {
                return mid;
            }else if(target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
