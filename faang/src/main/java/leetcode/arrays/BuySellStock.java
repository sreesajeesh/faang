package leetcode.arrays;

public class BuySellStock {

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(getMaxProfit2(arr));
    }

    public static int getMaxProfit(int[] prices){
        if(prices.length == 1) return 0;
        int left = 0;
        int right = 1;
        int sumOfProfit = 0;
        while(right < prices.length){
            int profit = prices[right] - prices[left];
            if( profit > 0){
                sumOfProfit += profit;
            }
            left++;
            right++;
        }
        return sumOfProfit;
    }

    public static int getMaxProfit2(int[] prices){
        if(prices.length == 1) return 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i-1] < prices[i]){
                profit = profit + prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
