package exclusive.algorithm.medium;

import java.util.Stack;
import java.util.stream.Collectors;

public class CompareTwoString {

    public static void main(String[] args) {
        String s1 = "abc#d";
        String s2 = "aBzz##d";
        System.out.println(compareByOptimum(s1, s2));

    }

    public static boolean compareByBrute(String s1, String s2){
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == '#'){
                if(!stack1.empty()){
                    stack1.pop();
                }
            } else {
                stack1.push(s1.charAt(i));
            }
        }
        for(int i = 0; i < s2.length(); i++){
            if(s2.charAt(i) == '#'){
                if(!stack2.empty()){
                    stack2.pop();
                }
            } else {
                stack2.push(s2.charAt(i));
            }
        }
        while(!stack1.empty()){
            str1.append(stack1.pop());
        }
        while(!stack2.empty()){
            str2.append(stack2.pop());
        }
        String string1 = str1.reverse().toString();
        String string2 = str2.reverse().toString();
        System.out.println(string1);
        System.out.println(string2);
        return string1.equalsIgnoreCase(string2);
        //return stack1.stream().map(Object::toString).collect(Collectors.joining("")).equals(stack2.stream().map(Object::toString).collect(Collectors.joining("")));
    }

    public static boolean compareByOptimum(String s1, String s2){
        int strRight1 = s1.length() -1;
        int strRight2 = s2.length() -1;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while (strRight1 >= 0 || strRight2 >= 0){
            if (s1.charAt(strRight1) == '#' || s2.charAt(strRight2) == '#') {
                if(s1.charAt(strRight1) == '#'){
                    int backCount = 2;
                    while(backCount > 0){
                        backCount--;
                        strRight1--;
                        if(s1.charAt(strRight1) == '#'){
                            backCount = backCount + 2;
                        }
                    }
                }
                if(s2.charAt(strRight2) == '#'){
                    int backCount = 2;
                    while(backCount > 0){
                        backCount--;
                        strRight2--;
                        if(s2.charAt(strRight2) == '#'){
                            backCount = backCount + 2;
                        }
                    }
                }
            } else {
                if (s1.toLowerCase().charAt(strRight1) != s2.toLowerCase().charAt(strRight2)){
                    return false;
                } else {
                    strRight1--;
                    strRight2--;
                }
            }
        }
        return true;
    }
}
