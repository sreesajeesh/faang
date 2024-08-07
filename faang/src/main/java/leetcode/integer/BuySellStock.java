package leetcode.integer;

public class BuySellStock {

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,4,6, 3,1};
        System.out.println(getMaxProfit(arr));

    }

    public static int getMaxProfit(int[] prices){
        int minPrice = prices[0];
        int maxPrice = 0;
        int i = 1;
        while(i < prices.length){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            maxPrice = Math.max((prices[i] - minPrice), maxPrice);
            i++;
        }
        return maxPrice;
    }
}
