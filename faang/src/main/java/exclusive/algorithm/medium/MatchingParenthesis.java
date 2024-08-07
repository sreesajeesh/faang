package exclusive.algorithm.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchingParenthesis {

    public static void main(String[] args) {
        String str = "((({}))";
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put('(',')');
        parenthesis.put('{','}');
        parenthesis.put('[',']');
        System.out.println(checkMatchHashMap(str, parenthesis));
    }

    public static boolean checkMatchHashMap(String str, Map<Character, Character> pMap){
        if(str.isEmpty()) return true;
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(pMap.containsKey(str.charAt(i))){
                charStack.push(str.charAt(i));
            } else {
                char leftBracket = charStack.pop();
                char correctBracket = pMap.get(leftBracket);
                if(str.charAt(i) != correctBracket) return false;
            }
        }
        return charStack.empty();
    }

    public static boolean checkMatch(String str){
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char strChar = str.charAt(i);
            switch (strChar){
                case ']':
                    if(!charStack.empty()) {
                        if (charStack.peek() == '[')
                            charStack.pop();
                        else
                            return false;
                    }
                    else
                        return false;
                    break;
                case ')':
                    if(!charStack.empty()) {
                        if (charStack.peek() == '(')
                            charStack.pop();
                        else
                            return false;
                    }
                    else
                        return false;
                    break;
                case '}':
                    if(!charStack.empty()) {
                        if (charStack.peek() == '{')
                            charStack.pop();
                        else
                            return false;
                    }
                    else
                        return false;
                    break;
                default:
                    charStack.push(strChar);
                    break;
            }
        }
        return charStack.empty();
    }
}
