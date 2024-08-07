package exclusive.algorithm.search;

public class MinHeap {

    public static void main(String[] args) {

    }

    public static boolean validMinHeap(BTNode node, int min){
        if(node == null) return false;
        if(node.left != null && node.right != null){
            if(node.left.data < min && node.right.data < min)
                return false;
            return validMinHeap(node.left, node.left.data) && validMinHeap(node.right, node.right.data);
        }
        return true;
    }
}
