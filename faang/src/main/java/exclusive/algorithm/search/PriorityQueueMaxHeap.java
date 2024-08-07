package exclusive.algorithm.search;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueMaxHeap {

    public static void main(String[] args) {
        PriorityQueue<Integer> pqHeap = new PriorityQueue<>(Collections.reverseOrder());
        pqHeap.add(20);
        pqHeap.add(40);
        pqHeap.add(50);
        pqHeap.add(25);
        pqHeap.add(35);
        pqHeap.add(10);
        pqHeap.add(15);

        for (Integer integer : pqHeap) System.out.print(integer + " ");
        System.out.println();

        pqHeap.add(45);
        for (Integer integer : pqHeap) System.out.print(integer + " ");
        System.out.println();

        pqHeap.remove();
        for (Integer integer : pqHeap) System.out.print(integer + " ");
        System.out.println();
    }
}
