package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIndex {

    public static void main(String[] args) {
        int[] arr = new int[] {2,7,11,15};
        //System.out.println(Arrays.toString(findSumIndex2(arr, 9)));
    }

    public static List<Integer> findSumIndex(int[] arr, int target){
        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            indexMap.put(arr[i], i);
        }

        for(Integer key : indexMap.keySet()){
            int remainder = target - key;
            if(remainder != key){
                if(indexMap.containsKey(remainder)){
                    indexList.add(key);
                    indexList.add(remainder);
                    break;
                }
            }
        }
        return indexList;
    }

    public static List<Integer> findSumIndexOptimum(int[] numbers, int target){
        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            if(indexMap.containsKey(diff)){
                indexList.add(i);
                indexList.add(indexMap.get(diff));
                break;
            } else {
                indexMap.put(numbers[i], i);
            }
        }
        return indexList;
    }

}
