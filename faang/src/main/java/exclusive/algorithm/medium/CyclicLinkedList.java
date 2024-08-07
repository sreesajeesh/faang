package exclusive.algorithm.medium;

import java.util.HashSet;
import java.util.Set;

public class CyclicLinkedList {

    public static void main(String[] args) {

    }

    public static boolean checkCycle(Node start){
        if(start == null)
            return false;
        Node currnetNode = start;
        Set<Node> nodeSet = new HashSet<>();

        while(!nodeSet.contains(currnetNode)){
            if(currnetNode.next == null)
                return false;
            nodeSet.add(currnetNode);
            currnetNode = currnetNode.next;
        }
        return true;
    }

    public static boolean checkCycleByTwoPointers(Node start){
        Node hare = start;
        Node tortoise = start;
        do {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare == null || hare.next == null) {
                return false;
            } else {
                hare = hare.next;
            }
        } while (tortoise != hare);
        Node p1 = start;
        Node p2 = tortoise;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1.data);
        return true;
    }
}
