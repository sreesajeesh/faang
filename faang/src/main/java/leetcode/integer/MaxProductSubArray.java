package leetcode.integer;

public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-1,-1};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums){
        if(nums.length == 1) return nums[0];
        int currentProduct = 1;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                currentProduct = currentProduct * nums[i];
                ans = Math.max(ans, currentProduct);
            }
            else {
                currentProduct = 1;
            }
        }

        currentProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] != 0){
                currentProduct = currentProduct * nums[i];
                ans = Math.max(currentProduct, ans);
            } else {
                currentProduct = 1;
            }
        }
        return ans;
    }

    public static int maxProductPerfect(int[] nums){
        if(nums.length == 1) return nums[0];
        int prefixProduct = 0;
        int suffixProduct = 0;
        int result = nums[0];

        for(int i = 0; i < nums.length; i++) {
            prefixProduct = (prefixProduct == 0 ? 1 : prefixProduct) * nums[i];
            suffixProduct = (suffixProduct == 0 ? 1 : suffixProduct) * nums[nums.length - i - 1];
            result = Math.max(result, Math.max(prefixProduct, suffixProduct));
        }
        return result;
    }

    public static int getMaxProduct(int[] nums){
        int ans = nums[0];
        int dpMin = nums[0]; // the minimum so far
        int dpMax = nums[0]; // the maximum so far

        for (int i = 1; i < nums.length; ++i) {
            final int num = nums[i];
            final int prevMin = dpMin; // dpMin[i - 1]
            final int prevMax = dpMax; // dpMax[i - 1]
            if (num < 0) {
                dpMin = Math.min(prevMax * num, num);
                dpMax = Math.max(prevMin * num, num);
            } else {
                dpMin = Math.min(prevMin * num, num);
                dpMax = Math.max(prevMax * num, num);
            }
            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}
