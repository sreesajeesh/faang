package exclusive.algorithm.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class FullCompleteBinaryTree {

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.left = new BTNode(2);
        head.right = new BTNode(3);
        head.left.left = new BTNode(4);
        head.left.right = new BTNode(5);
        head.right.left = new BTNode(6);
        head.right.right = new BTNode(7);
        System.out.println(countNodes(head));
    }

    public static boolean checkFullTree(BTNode node){
        if(node == null) return true;
        if(node.left == null && node.right == null)
            return true;
        if(node.right != null && node.left != null){
            return checkFullTree(node.left) && checkFullTree(node.right);
        }
        return false;
    }

    public static int getHeightOfTree(BTNode root){
        int height = 0;
        while (root.left != null){
            height++;
            root = root.left;
        }
        return height;
    }

    public static int countNodes(BTNode root){
        if(root == null) return 0;
        int height = getHeightOfTree(root);
        if(height == 0) return 1;
        int upperCount = (int) (Math.pow(2, height) - 1);
        System.out.println("Upper Count = " + upperCount);
        int left = 0;
        int right = upperCount;
        while (left < right){
            int indexToFind = (int) Math.ceil((double) (left + right) /2);
            System.out.println("Index to find = " + indexToFind);
            if (nodeExists(indexToFind, height, root)){
                left = indexToFind;
            }else
                right = indexToFind - 1;
        }
        return upperCount + left + 1;
    }

    public static int getHeightOfAnyTree(BTNode root){
        if(root == null)
            return 0;
        return Math.max(getHeightOfAnyTree(root.left), getHeightOfAnyTree(root.right)) + 1;
    }

    public static boolean nodeExists(int indexToFind, int height, BTNode node){
        int left = 0;
        int right = (int) (Math.pow(2, height) - 1);
        int count = 0;
        while (count < height){
            int midOfNode = (int) Math.ceil((double) (left + right) /2);
            if(indexToFind >= midOfNode){
                node = node.right;
                left = midOfNode;
            } else {
                node = node.left;
                right = midOfNode -1;
            }
            count++;
        }
        return node != null;
    }
}