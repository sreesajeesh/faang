package leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LastWordLength {

    public static void main(String[] args) {
        //String str = "Sajesh Kumar Anusree    Ashmitha";
        String str = "a ";
        System.out.println(lastWordLength3(str));
    }

    public static int lastWordLength(String str){
        LinkedList<String> strList = Arrays
                .stream(str.split("\\s"))
                .collect(Collectors.toCollection(LinkedList::new));
        return strList.getLast().length();
    }

    public static int lastWordLength2(String str){
        List<String> strList = Arrays
                .stream(str.split("\\s"))
                .toList();
        return strList.get(strList.size()-1).length();
    }

    public static int lastWordLength3(String str){
        int right = str.length() -1;
        int count = 0;
        if(str.length() == 1){
            if(str.charAt(0) == ' ')
                return 0;
            else
                return 1;
        }
        while(str.charAt(right) == ' '){
            right--;
        }
        while(str.charAt(right) != ' '){
            count++;
            right--;
            if(right == -1)
                break;
        }
        return count;
    }
}
