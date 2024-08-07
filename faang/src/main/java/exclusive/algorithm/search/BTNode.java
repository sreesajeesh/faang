package exclusive.algorithm.search;

public class BTNode {

    int data;
    BTNode left;
    BTNode right;
    BTNode prev;

    public BTNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.prev = null;
    }
}
