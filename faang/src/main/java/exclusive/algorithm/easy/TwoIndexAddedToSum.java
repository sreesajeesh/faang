package exclusive.algorithm.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoIndexAddedToSum {

    public static void main(String[] args) {
        int[] arr = {1,3,7,9,2};
        System.out.println(sumByOptimumSolution(arr, 11));

    }

    public static List<Integer> sumByBruteForce(int[] arr, int target){
        List<Integer> indexList = new ArrayList<>();
        for(int p1 = 0; p1 < arr.length - 1; p1++){
            int numberToFind = target - arr[p1];
            for(int p2 = p1 + 1; p2 < arr.length; p2++){
                if(numberToFind == arr[p2]) {
                    indexList.add(p1);
                    indexList.add(p2);
                    return indexList;
                }
            }
        }
        return indexList;
    }

    public static List<Integer> sumByOptimumSolution(int[] arr, int target){
        List<Integer> indexList = new ArrayList<>();
        Map<Integer, Integer> found = new HashMap<>();
        int numberToFind = -1;
        int currentMapValue = -1;
        for(int i = 0; i < arr.length; i++){
            if(found.containsKey(arr[i]))
                currentMapValue = found.get(arr[i]);
            if(currentMapValue >= 0){
                indexList.add(currentMapValue);
                indexList.add(i);
                return indexList;
            } else {
                numberToFind = target - arr[i];
                found.put(numberToFind, i);
            }
        }
        return null;
    }

    public static boolean findSumByOptimumSolution(int[] arr, int k){
        Map<Integer, Integer> found = new HashMap<>();
        int numberToFind = -1;
        int currentMapValue = -1;
        for(int i = 0; i < arr.length; i++){
            if(found.containsKey(arr[i]))
                currentMapValue = found.get(arr[i]);
            if(currentMapValue >= 0){
                return true;
            } else {
                numberToFind = k - arr[i];
                found.put(numberToFind, i);
            }
        }
        return false;
    }
}
