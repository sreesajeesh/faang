package exclusive.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCostStairs {

    public static void main(String[] args) {
        int[] steps = new int[]{20,15,30,5};
        System.out.println(bottomUpMinCostTwoVariable(steps));
    }

    //Bottom Up Approach

    public static int bottomUpMinCostTwoVariable(int[] steps){
        int first = steps[0];
        int second = steps[1];
        for(int i = 2; i < steps.length; i++){
            int current = steps[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }
    public static int bottomUpMinCost(int[] steps){
        int minCost = 0;
        int[] dp = new int[steps.length];
        for(int i = 0; i < steps.length; i++){
            if(i < 2) {
                dp[i] = steps[i];
            } else {
                dp[i] = steps[i] + Math.min(dp[i-1],dp[i-2] );
            }
        }
        return Math.min(dp[steps.length-1], dp[steps.length-2]);
    }
    public static int minCostStairs(int[] steps){
        int stepCount = steps.length;
        return Math.min(minCostSteps(stepCount -1, steps), minCostSteps(stepCount -2, steps));
    }

    public static int minCostSteps(int index, int[] steps){
        if(index < 0) return 0;
        if(index == 0 || index == 1) return steps[index];
        return steps[index] + Math.min(minCostSteps(index -1, steps), minCostSteps(index-2, steps));
    }

    //Better Solution to minimize time complexity
    public static int minBetterCostStair(int[] steps){
        int stepCount = steps.length;
        int[] dynamicArray = new int[steps.length];
        Arrays.fill(dynamicArray, -1);
        return Math.min(minBetterCostSteps(stepCount -1, steps, dynamicArray),
                minBetterCostSteps(stepCount - 2, steps, dynamicArray));
    }

    public static int minBetterCostSteps(int index, int[] steps, int[] dp){
        if(index < 0) return 0;
        if(index == 0 || index == 1) return steps[index];
        if(dp[index] >= 0) return dp[index];
        dp[index] = steps[index] + Math.min(minBetterCostSteps(index - 1, steps, dp),
                minBetterCostSteps(index - 2, steps, dp));
        return dp[index];
    }
}
