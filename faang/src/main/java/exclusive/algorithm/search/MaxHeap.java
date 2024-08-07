package exclusive.algorithm.search;

public class MaxHeap {

    public static void main(String[] args) {

        BTNode head = new BTNode(50);
        head.left = new BTNode(40);
        head.right = new BTNode(25);
        head.left.left = new BTNode(20);
        head.left.right = new BTNode(35);
        head.right.left = new BTNode(10);
        head.right.right = new BTNode(15);

        System.out.println(validMaxHeap(head, head.data));
    }

    public static boolean validMaxHeap(BTNode node, int max){
        if(node == null) return false;
        if(node.right != null && node.left != null) {
            if (node.right.data > max || node.left.data > max)
                return false;
            return validMaxHeap(node.left, node.left.data) && validMaxHeap(node.right, node.right.data);
        }
        return true;
    }

}
