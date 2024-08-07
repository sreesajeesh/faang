package leetcode.arrays;

public class BuySellStocksAgain {

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,4,6, 3,1};
        System.out.println(maxProfitStock(arr));
    }

    public static int maxProfitStock(int[] arr){
        int maxProfit = 0;
        int minPrice = arr[0];
        int i = 1;

        while(i < arr.length){
            if(minPrice > arr[i]){
                minPrice = arr[i];
            } else {
                maxProfit = Math.max(arr[i] - minPrice, maxProfit);
            }
            i++;
        }
        return maxProfit;
    }
}
