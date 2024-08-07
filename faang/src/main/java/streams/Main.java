package streams;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Map<Integer, Integer> fiboMap = new HashMap<>();
        fiboMap.put(0,0);
        fiboMap.put(1,1);
        int fibototal = fibonacci(10, fiboMap);
        System.out.println("Fibonacci of 10 : " + fibototal);
//        for(int i = 0; i < fiboMap.size(); i++){
//            System.out.println(i + " : " + fiboMap.get(i));
//        }

        fiboMap.forEach((k,v) -> System.out.println(k + " = " + v));

    }

    public static int fibonacci(int n, Map<Integer, Integer> fibomap){
        if(fibomap.containsKey(n)){
            return fibomap.get(n);
        } else {
//            int k = fibonacci(n-1, fibomap);
//            int m = fibonacci(n-2, fibomap);
            fibomap.put(n, fibonacci(n-1, fibomap)+fibonacci(n-2, fibomap));
            return fibomap.get(n);
        }

    }
}
