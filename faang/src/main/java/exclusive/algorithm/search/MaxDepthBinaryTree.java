package exclusive.algorithm.search;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {

        BTNode node = new BTNode(0);
        BTNode head = node;
        node.left = new BTNode(1);
        node.right = new BTNode(2);
        node.left.left = new BTNode(3);
        node.left.right = new BTNode(4);
        node.left.left.right = new BTNode(5);
        node.left.left.right.right = new BTNode(6);
        node.left.left.right.right.left = new BTNode(7);
        System.out.println(recursiveCount(head, 0));

    }

    public static int recursiveCount(BTNode node, int currentDepth){
        if(node == null)
            return currentDepth;
        currentDepth++;
        return Math.max(recursiveCount(node.left, currentDepth), recursiveCount(node.right, currentDepth));
    }
}
