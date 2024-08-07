package exclusive.algorithm.search;

public class BinarySearchTree {

    public static void main(String[] args) {
        BTNode node = new BTNode(12);
        node.left = new BTNode(7);
        node.left.left = new BTNode(5);
        node.left.right = new BTNode(9);
        node.left.right.left = new BTNode(8);
        node.left.right.right = new BTNode(11);
        node.right = new BTNode(18);
        node.right.left = new BTNode(14);
        node.right.left.right = new BTNode(15);
        node.right.left.right.right = new BTNode(16);
        node.right.left.right.right.right = new BTNode(17);
        node.right.right = new BTNode(25);

        //System.out.println(searchData(node, Integer.MIN_VALUE, Integer.MAX_VALUE, 8));
        System.out.println(validSearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    public static int searchData(BTNode node, int leftMinValue, int rightMaxValue, int target){
        if(node == null){
            return -1;
        }
        if(node.data == target)
            return target;
        if(node.data < target){
            leftMinValue = node.data;
            return searchData(node.right, leftMinValue, rightMaxValue, target);
        } else {
            rightMaxValue = node.data;;
            return searchData(node.left, leftMinValue, rightMaxValue, target);
        }
    }

    public static boolean validSearchTree(BTNode node, int leftMin, int rightMax){
        if(node == null) return true;
        if(node.data <= leftMin  || node.data >= rightMax)
            return false;
        if(node.left != null){
            if(!validSearchTree(node.left, leftMin, node.data))
                return false;
        }
        if(node.right != null){
            if(!validSearchTree(node.right, node.data, rightMax))
                return false;
        }
        return true;
    }
}
