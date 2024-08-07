package faang.algorithm.sliding_window;

public class MaxAverageSubArray {

    /*
        You are given an integer array nums consisting of n elements, and an integer k.

        Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
        Any answer with a calculation error less than 10-5 will be accepted.

        Try to find in two ways one worst option and other one best option
     */

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, -5, -6, 50, 2};

        //System.out.println("Bad Max Array Value : " + findBadMaxAverageSubArray(arr, 4));

        System.out.println("Good Max Array Value : " + findGoodMaxAverageSubArray(arr, 4));
    }

    public static double findBadMaxAverageSubArray(int[] nums, int k){
        double max = Double.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            double slidingWindow = 0;
            for(int j = 0; j < k; j++){
                if((i + k) <= nums.length ) {
                        slidingWindow = slidingWindow + nums[i + j];
                }
            }
            System.out.println(slidingWindow);
            if(slidingWindow != 0)
                max = Math.max(slidingWindow/k, max);
        }
        return max;
    }

    public static double findGoodMaxAverageSubArray(int[] nums, int k){
        double max = Double.MIN_VALUE;
        double slidingWindow = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            slidingWindow = slidingWindow + nums[i];
            if((i - start + 1) == k){
                System.out.println(slidingWindow);
                max = Math.max(slidingWindow/4, max);
                slidingWindow = slidingWindow - nums[start];
                start++;
            }
        }
        return max;
    }
}
