package exclusive.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NetworkTimeDelay {

    public static void main(String[] args) {
        List<List<Integer>> network = new ArrayList<>();
        network.add(Arrays.asList(1,2,9));
        network.add(Arrays.asList(1,4,2));
        network.add(Arrays.asList(2,5,1));
        network.add(Arrays.asList(4,2,4));
        network.add(Arrays.asList(4,5,6));
        network.add(Arrays.asList(3,2,3));
        network.add(Arrays.asList(5,3,7));
        network.add(Arrays.asList(3,1,5));
        for(List<Integer> nodeList : network){
            for(Integer node : nodeList){
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println(networkDelayTime(network, 5, 1));
    }

    public static int networkDelayTime(List<List<Integer>> times, int nodes, int startNode){
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for(List<Integer> time : times){
            int source = time.get(0);
            int target = time.get(1);
            int weight = time.get(2);
            if(!graph.containsKey(source)){
                graph.put(source, new LinkedList<List<Integer>>());
            }
            graph.get(source).add(List.of(target, weight));
        }
        Queue<List<Integer>> minHeap = new PriorityQueue<>((a,b)-> a.get(1) - b.get(1));
        Set<Integer> visited = new HashSet<>();
        minHeap.add(List.of(startNode, 0));
        int result = 0;
        while (!minHeap.isEmpty()){
            List<Integer> top = minHeap.poll();
            int source = top.get(0);
            int sourceWeight = top.get(1);
            if(visited.contains(source)) continue;
            result = sourceWeight;
            visited.add(source);
            if(!graph.containsKey(source)) continue;
            for(List<Integer> edge : graph.get(source)){
                int target = edge.get(0);
                int targetWeight = edge.get(1);
                minHeap.add(List.of(target, sourceWeight + targetWeight));
            }
        }
        return visited.size() == nodes? result : -1;
    }
}
