package leetcode.integer;

import java.util.HashMap;
import java.util.Map;

public class IntegerRoman {

    public static void main(String[] args) {
        Map<Integer, String> roman = new HashMap<>();
        roman.put(1, "I");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(9, "IX");
        roman.put(10, "X");
        roman.put(40, "XL");
        roman.put(50, "L");
        roman.put(90, "XC");
        roman.put(100, "C");
        roman.put(400, "CD");
        roman.put(500, "D");
        roman.put(900, "CM");
        roman.put(1000, "M");
        Map<Integer, Integer> order = new HashMap<>();
        order.put(0, 1);
        order.put(1, 4);
        order.put(2, 5);
        order.put(3, 9);
        order.put(4, 10);
        order.put(5, 40);
        order.put(6, 50);
        order.put(7, 90);
        order.put(8, 100);
        order.put(9, 400);
        order.put(10, 500);
        order.put(11, 900);
        order.put(12, 1000);
        System.out.println(getRoman(3856, roman, order));
    }

    public static String getRoman(int value, Map<Integer, String> roman, Map<Integer, Integer> order){
        int temp = value;
        StringBuilder romanStr = new StringBuilder();
        int orderCount = order.size() - 1;
        while (temp > 0){
            while(temp >= order.get(orderCount)){
                romanStr.append(roman.get(order.get(orderCount)));
                temp = temp - order.get(orderCount);
            }
            orderCount--;
        }
        return romanStr.toString();
    }
}
