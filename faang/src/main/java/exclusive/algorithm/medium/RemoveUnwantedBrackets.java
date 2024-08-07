package exclusive.algorithm.medium;

import java.util.Stack;

public class RemoveUnwantedBrackets {

    public static void main(String[] args) {
        String str = "abcd(e))f";
        System.out.println(removeUnwanted(str));
    }

    public static String removeUnwanted(String str){
        char[] strChars = str.toCharArray();
        Stack<Integer> stackChars = new Stack<>();
        for(int i = 0; i < strChars.length; i++){
            if(strChars[i] == '('){
                stackChars.push(i);
            } else if(strChars[i] == ')' && !stackChars.isEmpty()){
                stackChars.pop();
            } else if(strChars[i] == ')') {
                strChars[i] = ' ';
            }
        }
        while (!stackChars.isEmpty()){
            int index = stackChars.pop();
            strChars[index] = ' ';
        }
        String newStr = String.copyValueOf(strChars);
        newStr = newStr.replaceAll("\\s", "");
        return newStr;
    }
}
