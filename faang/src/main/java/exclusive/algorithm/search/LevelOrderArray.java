package exclusive.algorithm.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class LevelOrderArray {

    public static void main(String[] args) {

        BTNode node = new BTNode(3);
        BTNode head = node;
        node.left = new BTNode(6);
        node.right = new BTNode(1);
        node.left.left = new BTNode(9);
        node.left.right = new BTNode(2);
        node.left.left.right = new BTNode(5);
        node.left.left.right.left = new BTNode(8);
        node.right.right = new BTNode(4);
/*
        int[] arr = levelOrder(head);
        for (int j : arr) {
            if(j != 0 )
                System.out.print(j + ", ");
        }
        System.out.println();

 */
        levelOrderSubArray(head)
                .forEach(System.out::println);
    }

    public static int[] levelOrder(BTNode start){
        int[] arr = new int[20];
        int arrCount = 0;
        Queue<BTNode> qNode = new ArrayDeque<>();
        qNode.add(start);
        while (!qNode.isEmpty()){
            BTNode node = qNode.remove();
            arr[arrCount++] = node.data;
            if(node.left != null) qNode.add(node.left);
            if(node.right != null) qNode.add(node.right);
        }
        return arr;
    }

    public static List<Integer> levelOrderSubArray(BTNode start){
        if(start == null) return null;
        List<Integer> result = new ArrayList<>();
        Queue<BTNode> qNode = new ArrayDeque<>();
        qNode.add(start);
        while (!qNode.isEmpty()){
            int qSize = qNode.size();
            int count = 0;
            List<Integer> currentLevelList = new ArrayList<>();
            while (count < qSize){
                BTNode node = qNode.remove();
                currentLevelList.add(node.data);
                if(node.left != null) qNode.add(node.left);
                if(node.right != null) qNode.add(node.right);
                count++;
            }
            result.addAll(currentLevelList);
        }
        return result;
    }
}
