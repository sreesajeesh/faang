package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IntegerToWord {

    public static void main(String[] args) {
        System.out.println(getValue(1234567));
    }

    public static String getValue(int num){
        if(num == 0) return "Zero";
        int temp = num;
        int i = 0;
        StringBuilder words = new StringBuilder();

        while(temp > 0) {
            if(temp % 1000 != 0){
                System.out.println(temp);
                words.insert(0, helper(temp % 1000) + Thousands.lookUpByName(i) + " ");
            }
            temp /= 1000;
            i++;
        }
        return words.toString().trim();
    }

    public static String helper(int n){
        if(n == 0){
            return "";
        } else if(n < 20){
            return Less_Than_20.lookUpByName(n) + " ";
        } else if(n < 100){
            System.out.println(n);
            System.out.println(Tens.lookUpByName(n/10));
            return Tens.lookUpByName(n/10) + " " + helper(n % 10);
        } else {
            return Less_Than_20.lookUpByName(n/100) + " " + "Hundred " + helper(n % 100);
        }
    }
}

enum Less_Than_20 {
    ZERO (0), One (1), Two (2),Three(3), Four(4),
    Five(5), Six(6), Seven(7), Eight(8), Nine(9),
    Ten(10), Eleven(11), Twelve(12), Thirteen(13), Fourteen(14),
    Fifteen(15), Sixteen(16), Seventeen(17), Eighteen(18), Nineteen(19);

    private final int value;
    Less_Than_20(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static final Map<Integer, String> numIndex = new HashMap<>();

    static {
        int i = 0;
        for(Less_Than_20 value : Less_Than_20.values()){
            if(i == 0)
                numIndex.put(i++, "");
            else
                numIndex.put(i++, value.name());
        }
    }

    public static String lookUpByName(int i){
        return numIndex.get(i);
    }
}

enum Tens {
    ZERO (0), Ten(1), Twenty(2), Thirty(3), Forty(4), Fifty(5),
    Sixty(6), Seventy(7), Eighty(8), Ninety(9);

    private final int value;
    Tens(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static final Map<Integer, String> numIndex = new HashMap<>();

    static {
        int i = 0;
        for(Tens value : Tens.values()){
            if(i == 0)
                numIndex.put(i++, "");
            else
                numIndex.put(i++, value.name());
        }
    }

    public static String lookUpByName(int i){
        return numIndex.get(i);
    }
}

enum Thousands {

    Zero(0), Thousand(1), Million(2), Billion(3);
    private final int value;
    Thousands(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static final Map<Integer, String> numIndex = new HashMap<>();

    static {
        int i = 0;
        for(Thousands value : Thousands.values()){
            if(i == 0)
                numIndex.put(i++, "");
            else
                numIndex.put(i++, value.name());
        }
    }

    public static String lookUpByName(int i){
        return numIndex.get(i);
    }
}