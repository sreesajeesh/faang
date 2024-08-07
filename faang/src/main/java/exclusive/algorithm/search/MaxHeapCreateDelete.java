package exclusive.algorithm.search;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MaxHeapCreateDelete {

    public static TreeMap<Integer, BTNode> nodeTreeMap = new TreeMap<>();
    public static Integer key = 0;

    public static void main(String[] args) {
        BTNode head = new BTNode(50);
        head.left = new BTNode(40);
        head.right = new BTNode(25);
        head.left.left = new BTNode(20);
        head.left.right = new BTNode(35);
        head.right.left = new BTNode(10);
        head.right.right = new BTNode(15);

        printLevelOrder(head);
        System.out.println();
//        Collection<BTNode> btNodeCollection = nodeTreeMap.values();
//        for(BTNode node : btNodeCollection){
//            System.out.println(node.data);
//        }
        Set<Map.Entry<Integer, BTNode>> entries = nodeTreeMap.entrySet();

//using for loop
        for(Map.Entry<Integer, BTNode> entry : entries){
            System.out.print( entry.getKey() + "=>" + entry.getValue().data + " " );
        }
        System.out.println();
        insertNodeMaxHeap(nodeTreeMap, 45);
        entries = nodeTreeMap.entrySet();

//using for loop
        for(Map.Entry<Integer, BTNode> entry : entries){
            System.out.print( entry.getKey() + "=>" + entry.getValue().data + " ");
        }
        System.out.println();
        deleteMaxValue(nodeTreeMap);
        entries = nodeTreeMap.entrySet();

//using for loop
        for(Map.Entry<Integer, BTNode> entry : entries){
            System.out.print( entry.getKey() + "=>" + entry.getValue().data + " ");
        }
        System.out.println();
    }

    public static void deleteMaxValue(TreeMap<Integer, BTNode> treeMap){
        BTNode maxNode = treeMap.get(0);
        BTNode lastNode = treeMap.get(treeMap.size()-1);
        System.out.println(maxNode.data + " " + lastNode.data);
        maxNode.data = lastNode.data;
        treeMap.remove(treeMap.size()-1);
        int index = 0;
        while(true){
            int left = (index * 2) +1;
            int right = (index * 2) +2;
            if(left >= treeMap.size() || right >= treeMap.size())
                break;
            if(treeMap.get(left).data > treeMap.get(right).data){
                if(treeMap.get(left).data > maxNode.data){
                    BTNode tempNode = treeMap.get(left);
                    int value = tempNode.data;
                    tempNode.data = maxNode.data;
                    maxNode.data = value;
                    maxNode = tempNode;
                    index = left;
                } else if(treeMap.get(right).data > maxNode.data){
                    BTNode tempNode = treeMap.get(right);
                    int value = tempNode.data;
                    tempNode.data = maxNode.data;
                    maxNode.data = value;
                    maxNode = tempNode;
                    index = right;
                } else
                    break;
            }
        }
    }
    public static void insertNodeMaxHeap(TreeMap<Integer, BTNode> treeMap, int data){
        Integer lastKey = treeMap.lastKey();
        BTNode node = new BTNode(data);
        BTNode insertedNode = node;
        treeMap.put(lastKey + 1, node);
        int parentIndex = (int) Math.floor((double) (treeMap.size() -1)/2);
        while (true){
            //System.out.println(treeMap.get(parentIndex).data);
            if(treeMap.get(parentIndex).data < insertedNode.data){
                BTNode tempNode = treeMap.get(parentIndex);
                int value = tempNode.data;
                tempNode.data = insertedNode.data;
                insertedNode.data = value;
                insertedNode = tempNode;
                parentIndex = (int) Math.floor((double) parentIndex/2);
            } else
                break;
        }
    }
    public static int getHeightOfTree(BTNode root){
        int height = 0;
        while (root.left != null){
            height++;
            root = root.left;
        }
        return height;
    }

    public static void printLevelOrder(BTNode root)
    {
        int h = getHeightOfTree(root) + 1;
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
    public static void printCurrentLevel(BTNode root, int level)
    {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
            nodeTreeMap.put(key++, root);
        }
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
}
