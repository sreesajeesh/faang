package exclusive.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonElementTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,6,7,9};
        int[] arr2 = new int[]{1,2,4,5,9,10};

        System.out.println(getCommonElementOptimum(arr1, arr2));

    }

    public static List<Integer> getCommonElements(int[] arr1, int[] arr2){
        List<Integer> commonList = new ArrayList<>();
        HashMap<Integer, Integer> elements = new HashMap<>();
        for(int j : arr1){
            if(!elements.containsKey(j)){
                elements.put(j,1);
            } else {
                int value = elements.get(j);
                elements.put(j, value + 1);
            }
        }
        for(int j : arr2){
            if(!elements.containsKey(j)){
                elements.put(j,1);
            } else {
                int value = elements.get(j);
                elements.put(j, value + 1);
            }
        }
        return elements.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Integer> getCommonElementOptimum(int[] arr1, int[] arr2){
        List<Integer> commonList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                commonList.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]){
                j++;
            } else {
                i++;
            }
        }
        return commonList;
    }
}
