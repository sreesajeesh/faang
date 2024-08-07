package exclusive.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String str = "aabbccdkkeefgh";
        getFirstOccurrence(str);
    }

    public static void getFirstOccurrence(String str){
        HashMap<Character, Integer[]> charMap = new HashMap<>();
        int firstIndex = 0;
        for(int i = 0; i < str.length(); i++){
            if(!charMap.containsKey(str.charAt(i))){
                Integer[] list = new Integer[2];
                list[0] = firstIndex;
                list[1] = 1;
                charMap.put(str.charAt(i), list);
                firstIndex++;
            } else {
                Integer[] list = charMap.get(str.charAt(i));
                //int index = list[0];
                list[1]++;
                charMap.put(str.charAt(i), list);
            }
        }
        //System.out.println(charMap);
        for(Map.Entry<Character, Integer[]> map : charMap.entrySet()){
            if(map.getValue()[1] == 1){
                System.out.println(map.getValue()[0]);
                System.out.println(map.getKey());
                break;
            }
        }
        for(Map.Entry<Character, Integer[]> map : charMap.entrySet()){
            System.out.print(map.getKey() + "[");
            for(int i = 0; i < map.getValue().length; i++){
                System.out.print(map.getValue()[i] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
