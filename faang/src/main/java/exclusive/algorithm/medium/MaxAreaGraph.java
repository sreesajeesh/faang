package exclusive.algorithm.medium;

public class MaxAreaGraph {

    public static void main(String[] args) {
        int[] arr = {4,8,1,2,3,9};
        System.out.println(maxAreaByOptimum(arr));
    }

    public static int maxAreaByBrute(int[] arr){
        int maxArea = 0;
        for(int p1 = 0; p1 < arr.length - 1; p1++){
            for(int p2 = p1 + 1; p2 < arr.length; p2++){
                maxArea = Math.max((Math.min(arr[p1], arr[p2])* (p2 - p1)), maxArea);
            }
        }
        return maxArea;
    }

    public static int maxAreaByOptimum(int[] arr){
        int p1 = 0;
        int p2 = arr.length-1;
        int maxArea = 0;
        while (p1 < p2){
            maxArea = Math.max((Math.min(arr[p1], arr[p2])* (p2 - p1)), maxArea);
            if(arr[p1] <= arr[p2])
                p1++;
            else
                p2--;
        }
        return maxArea;
    }
}
