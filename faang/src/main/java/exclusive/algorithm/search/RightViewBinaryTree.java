package exclusive.algorithm.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {

    public static void main(String[] args) {

        BTNode head = new BTNode(1);
        head.left = new BTNode(2);
        head.right = new BTNode(3);
        head.left.left = new BTNode(4);
        head.left.right = new BTNode(5);
        head.left.left.right = new BTNode(7);
        head.left.left.right.left = new BTNode(8);
        head.right.right = new BTNode(6);
        rightViewNodes(head).forEach(System.out::println);
    }

    public static List<Integer> rightViewNodes(BTNode start){
        List<Integer> rightViewList = new ArrayList<>();
        depthFirstSearch(start, 0, rightViewList);
        return rightViewList;

    }

    public static void depthFirstSearch(BTNode node, int level, List<Integer> resultList){
        if(node == null) return;
        if(level >= resultList.size()){
            resultList.add(node.data);
        }
        if(node.right != null){
            depthFirstSearch(node.right, level+1, resultList);
        }
        if(node.left != null){
            depthFirstSearch(node.left, level +1, resultList);
        }
    }
}
