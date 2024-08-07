package exclusive.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 5;
        HashMap<Integer, Integer> fiboMap = new HashMap<>();
        fiboMap.put(0,0);
        fiboMap.put(1,1);
        fiboSeries(6, fiboMap);
        System.out.println(new ArrayList<>(fiboMap.values())
        );
    }

    public static int fiboSeries(int n, HashMap<Integer, Integer> fiboMap){
        if(fiboMap.containsKey(n))
            return fiboMap.get(n);
        else {
            fiboMap.put(n, fiboSeries(n -1, fiboMap) + fiboSeries(n-2, fiboMap));
            return fiboMap.get(n);
        }
    }
}
