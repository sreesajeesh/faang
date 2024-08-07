package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateNumberList {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,4,6,7,8,7,1};
        System.out.println(getDuplicates(arr));
    }

    public static List<Integer> getDuplicatesUsingStream(int[] nums){

        return IntStream.of(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Integer> getDuplicates(int[] nums){
        List<Integer> array = new ArrayList<>();
        int[] arr = new int[nums.length + 1];

        for (int num : nums){
            arr[num]++;
            if(arr[num] > 1)
                array.add(num);
        }
        return array;
    }
}
