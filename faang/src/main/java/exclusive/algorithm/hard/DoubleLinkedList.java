package exclusive.algorithm.hard;

public class DoubleLinkedList {

    public static void main(String[] args) {

        ListNode secondLevel = null;
        ListNode head = new ListNode(1);
        ListNode currentNode = head;
        for(int i = 2; i <= 6; i++ ){
            currentNode.next = new ListNode(i);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        currentNode = head;
        while (true){
            if(currentNode.data == 2){
                ListNode initialNode = new ListNode(7);
                currentNode.child = initialNode;
                secondLevel = initialNode;
                for(int i = 8; i <= 9; i++){
                    initialNode.next = new ListNode(i);
                    initialNode.next.prev = initialNode;
                    initialNode = initialNode.next;
                }
                break;
            } else
                currentNode = currentNode.next;
        }
        currentNode = secondLevel;
        if(currentNode.data == 8){
            ListNode initialNode = new ListNode(10);
            currentNode.child = initialNode;
            initialNode.next = new ListNode(11);
            initialNode.next.prev = initialNode;
            initialNode = initialNode.next;
        }
        currentNode = head;
        while (true){
            if(currentNode.data == 5){
                ListNode initialNode = new ListNode(12);
                currentNode.child = initialNode;
                secondLevel = initialNode;
                for(int i = 13; i <= 14; i++){
                    initialNode.next = new ListNode(i);
                    initialNode.next.prev = initialNode;
                    initialNode = initialNode.next;
                }
                break;
            } else
                currentNode = currentNode.next;
        }
    }

    public static ListNode flatPerfect(ListNode start){
        ListNode currentNode = start;
        if(start == null) return null;
        while(currentNode.next != null){
            if(currentNode.child == null){
                currentNode = currentNode.next;
            } else{
                ListNode tail = currentNode.child;
                while (tail.next != null){
                    tail = tail.next;
                }
                tail.next = currentNode.next;
                if(tail.next != null){
                    tail.next.prev = tail;
                }
                currentNode.next = currentNode.child;
                currentNode.next.prev = currentNode;
                currentNode.child = null;
            }
        }
        return start;
    }

    public static void flattenDoubleLinkedList(ListNode start){
        ListNode currentNode = start;
        while (currentNode != null){
            if(currentNode.child != null){
                flatList(currentNode, currentNode.next);
            }
            currentNode = currentNode.next;
        }
    }

    public static void flatList(ListNode haveChildNode, ListNode nextNode){
        ListNode childNode = haveChildNode.child;
        ListNode tempNext = haveChildNode.next;
        haveChildNode.next = childNode;
        haveChildNode.child = null;
        while(childNode.next != null){
            if(childNode.child != null){
                flatList(childNode, childNode.next);
            }
            childNode = childNode.next;
        }
        childNode.next = nextNode;
        nextNode.prev = childNode;
    }
}
