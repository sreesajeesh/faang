package exclusive.dojo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MostFrequentOccur {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,1,3,2,1};
        System.out.println(greatestFrequency(arr));
    }

    public static int greatestFrequency(int[] arr){
        HashMap<Integer, Integer> intMap = new HashMap<>();
        int maxCount = -1;
        int maxItem = Integer.MAX_VALUE;
        for (int j : arr) {
            if (!intMap.containsKey(j)) {
                intMap.put(j, 1);
            } else {
                int count = intMap.get(j);
                intMap.put(j, count + 1);
            }
            if (intMap.get(j) > maxCount) {
                maxCount = intMap.get(j);
                maxItem = j;
            }
        }
//        Optional<Map.Entry<Integer,Integer>> maxEntry = intMap.entrySet()
//                .stream().max(Comparator.comparing(Map.Entry::getValue));
//        return maxEntry.get().getKey();
        return maxItem;
    }
}
