package exclusive.dynamic_programming;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {

        HashMap<Integer, Integer> intMap = new HashMap<>();
        intMap.put(0,0);
        intMap.put(1,1);
        //System.out.println(resultWithDynamic(7, intMap));
        int[] dp = new int[8];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(resultOptimal(7));
        
    }

    public static int resultTabular(int n, int[] dp){
        for(int i = 2; i <= n; i++ ){
            dp[i] = dp[i -1] + dp[i -2];
        }
        return dp[n];
    }

    public static int resultOptimal(int n){
        int current = 0;
        int previous = 1;
        int beforePrevious = 0;
        System.out.println(beforePrevious);
        System.out.println(previous);
        for(int i = 2; i <= n; i++){
            current = previous + beforePrevious;
            System.out.println(current);
            beforePrevious = previous;
            previous = current;
        }
        return current;
    }

    public static int result(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n > 1)
            return result(n -1) + result(n -2);
        return 0;
    }

    public static int resultWithDynamic(int n, HashMap<Integer, Integer> intMap){
        if(intMap.containsKey(n))
            return intMap.get(n);
        else {
            intMap.put(n, resultWithDynamic(n - 1, intMap) + resultWithDynamic(n - 2, intMap));
            return intMap.get(n);
        }
    }
}
