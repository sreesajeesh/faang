package leetcode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KDiffPairs {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,1,5};
        System.out.println(diffPairs(arr, 2));
    }

    public static int diffPairs(int[] nums, int k) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        List<Integer> integerList = Arrays.stream(nums).boxed().toList();
        int value;
        for (int num : nums) {
            if (k != 0) {
                if (!diffMap.containsKey(num)) {
                    if(num < k)
                        value = k + num;
                    else
                        value = k - num;
                    if(!diffMap.containsKey(Math.abs(value))) {
                        if (integerList.contains(Math.abs(value)))
                            if (Math.abs(value) != num)
                                diffMap.put(num, Math.abs(value));
                    }
                }
            } else {
                return (int) Arrays.stream(nums).boxed()
                        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter((a) -> a.getValue() > 1)
                        .count();
            }
        }
        System.out.println(diffMap);
        return diffMap.size();
    }

    public static int getDiff2(int[] nums, int k) {
        int count = 0;
        if (k != 0) {
            Map<Integer, Long> integerMap = Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

            for (Integer key : integerMap.keySet()) {
                int value = k + key;
                if (integerMap.containsKey(value)) {
                    count++;
                }
            }
        } else {
            return (int) Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter((a) -> a.getValue() > 1)
                    .count();
        }
        return count;
    }
}
//System.out.println(diffMap);