package exclusive.algorithm.medium;

import java.util.LinkedList;

public class ReverseLinkedList {

    static Node head;

    static class Node {
        Integer data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
//        System.out.println(linkedList);
//        Collections.reverse(linkedList);
//        System.out.println(linkedList);
        //ReverseLinkedList list = new ReverseLinkedList();
        head = new Node(1);
        Node currentNode = head;
        for(int i = 2; i <= 6; i++){
            currentNode.next = new Node(i);
            currentNode = currentNode.next;
        }
        printList(head);
        System.out.println();
        printList(reverseNodeIndex(head, 2, 5));
    }

    public static Node reverseNode(Node start){
        Node prev = null;
        Node current = start;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start = prev;
        return start;
    }

    public static Node reverseNodeIndex(Node head, int left, int right){
        int currentPos = 1;
        Node currentNode = head;
        Node start = head;
        while(currentPos < left){
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }
        Node newNode = null;
        Node tail = currentNode;
        while(currentPos >= left && currentPos <= right){
            Node next = currentNode.next;
            currentNode.next = newNode;
            newNode = currentNode;
            currentNode = next;
            currentPos++;
        }
        start.next = newNode;
        tail.next = currentNode;

        if(left > 1){
            return head;
        } else {
            return newNode;
        }
    }

    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static LinkedList<Integer> reverseList(LinkedList<Integer> list){
        for(int i = 0; i < list.size()/2; i++){
            Integer temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i -1, temp);
        }
        return list;
    }
}
