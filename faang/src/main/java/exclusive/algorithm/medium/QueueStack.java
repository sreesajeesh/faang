package exclusive.algorithm.medium;

import java.util.Stack;

public class QueueStack {

    public static void main(String[] args) {
        twoStackQueue();
    }

    public static void twoStackQueue(){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> reverseStack = new Stack<>();
        for(int i=1; i < 6; i++){
            //System.out.println(i);
            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.peek());
            System.out.print(" ");
            reverseStack.push(stack.pop());
        }

        System.out.println();
        while (!reverseStack.isEmpty()){
            System.out.print(reverseStack.pop());
            System.out.print(" ");
        }
        System.out.println();
    }
}
