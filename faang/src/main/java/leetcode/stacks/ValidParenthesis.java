package leetcode.stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        //System.out.println(checkValid("({[)"));
        System.out.println(checkValid("{[]}"));
    }

    public static boolean checkValid(String str){
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(charStack.isEmpty()){
                charStack.push(str.charAt(i));
            } else {
                char forward = charStack.peek();
                switch (forward) {
                    case '{':
                        if (str.charAt(i) == '}')
                            charStack.pop();
                        else
                            charStack.push(str.charAt(i));
                        break;
                    case '(':
                        if (str.charAt(i) == ')')
                            charStack.pop();
                        else
                            charStack.push(str.charAt(i));
                        break;
                    case '[':
                        if (str.charAt(i) == ']')
                            charStack.pop();
                        else
                            charStack.push(str.charAt(i));
                        break;
                    default:
                        charStack.push(str.charAt(i));
                        break;
                }
            }
        }
        return charStack.isEmpty();
    }
}
