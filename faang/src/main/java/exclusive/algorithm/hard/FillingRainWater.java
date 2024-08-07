package exclusive.algorithm.hard;

public class FillingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 3, 1, 0, 2, 1};
        System.out.println(fillRainWaterByOptimum(arr));
    }

    public static int fillRainWaterByBrute(int[] arr){
        int totalWater = 0;
        for(int p =0; p < arr.length; p++){
            int leftP = p;
            int rightP = p;
            int maxLeft = 0;
            int maxRight = 0;
            while(leftP >= 0){
                maxLeft =  Math.max(maxLeft, arr[leftP]);
                leftP--;
            }
            while(rightP < arr.length){
                maxRight =  Math.max(maxRight, arr[rightP]);
                rightP++;
            }
            int currentWater = Math.min(maxLeft, maxRight) - arr[p];
            if(currentWater >= 0)
                totalWater += currentWater;
        }
        return totalWater;
    }

    public static int fillRainWaterByOptimum(int[] arr){
        int leftP = 0;
        int rightP = arr.length -1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        while(leftP < rightP){
            if(arr[leftP] <= arr[rightP]){
                if(arr[leftP] >= maxLeft){
                    maxLeft = arr[leftP];
                } else {
                    totalWater += maxLeft - arr[leftP];
                }
                leftP++;
            } else {
                if(arr[rightP] >= maxRight){
                    maxRight = arr[rightP];
                } else {
                    totalWater += maxRight - arr[rightP];
                }
                rightP--;
            }
        }
        return totalWater;
    }
}
