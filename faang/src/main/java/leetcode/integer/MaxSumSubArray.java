package leetcode.integer;

public class MaxSumSubArray {

    public static void main(String[] args) {
        //int[] arr = new int[]{-2,-3, 4, -1, 2, 1, -5, 4};
        int[] arr = new int[]{5,4,-1,7,-8};
        System.out.println(getMaxSumArray(arr));
    }

    public static int getMaxSumArray(int[] nums){
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        int firstIndex = 0;
        int finalIndex = 0;
        int i = 1;
        while(i < nums.length){
            if(currentSum < 0){
                currentSum = nums[i];
                firstIndex = i;
            } else {
                currentSum = currentSum + nums[i];
            }
            if(currentSum > maxSoFar){
                finalIndex = i;
                maxSoFar = currentSum;
            }
            i++;
        }
        for(int j = firstIndex; j <= finalIndex; j++){
            System.out.println(nums[j]);
        }
        return maxSoFar;
    }

    public static int getMaxSumArrayInt(int[] nums){
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        int i = 1;
        while(i < nums.length){
            if(currentSum < 0){
                currentSum = nums[i];
            } else {
                currentSum = currentSum + nums[i];
            }
            if(currentSum > maxSoFar){
                maxSoFar = currentSum;
            }
            i++;
        }
        return maxSoFar;
    }
}
