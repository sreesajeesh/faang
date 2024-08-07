package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DisappearedNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,5,10,9,1,1,4,3,7};
        System.out.println(disappearedList4(arr));
    }

    public static List<Integer> disappearedList(int[] nums){
        Map<Integer, Integer> arrayMap = new HashMap<>();
        List<Integer> integerList = new ArrayList<>();
        for (int num : nums) {
            if (!arrayMap.containsKey(num)) {
                arrayMap.put(num, 1);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!arrayMap.containsKey(i)){
                integerList.add(i);
            }
        }
        return integerList;
    }

    public static List<Integer> disappearedList2(int[] nums){
        Set<Integer> integerSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= nums.length ; i++) {
            if(!integerSet.contains(i))
                integerList.add(i);
        }
        return integerList;
     }

    public static List<Integer> disappearedList3(int[] nums){
        Set<Integer> integerSet = new HashSet<>();
        for(int num : nums){
            integerSet.add(num);
        }
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= nums.length ; i++) {
            if(!integerSet.contains(i))
                integerList.add(i);
        }
        return integerList;
    }

    public static List<Integer> disappearedList4(int[] nums){
        List<Integer> array = new ArrayList<>();
        int[] arr = IntStream.rangeClosed(1, nums.length).toArray();
        for(int num : nums){
            if(num == arr[num -1])
                arr[num - 1] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(arr[i] > 0)
                array.add(arr[i]);
        }
        return array;
    }

}
