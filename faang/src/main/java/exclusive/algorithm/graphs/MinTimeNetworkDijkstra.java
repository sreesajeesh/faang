package exclusive.algorithm.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class MinTimeNetworkDijkstra {

    public static void main(String[] args) throws InterruptedException {

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

    public static int networkDelayTime(List<List<Integer>> times, int nodes, int startNode) throws InterruptedException {
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        HashMap<Integer, List<List<Integer>>> adjustList = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> distanceMap.get(a) - distanceMap.get(b));
        // Fill value of distance map as infinity
        // Generate the list for adjustList
        for (int i = 1; i <= nodes; i++){
            distanceMap.put(i, Integer.MAX_VALUE);
            List<List<Integer>> list = new ArrayList<>();
            adjustList.put(i, list);
        }
        //Time for start node is always 0 amd add start node to priority queue
        distanceMap.put(startNode, 0);
        heap.add(startNode);

        //from network fetch the list first one is source node, second one is target node and third one is weight value
        //Against source node add list of target node and weight value
        for (List<Integer> list : times) {
            Integer source = list.get(0);
            Integer target = list.get(1);
            Integer weight = list.get(2);
            List<Integer> tw = Arrays.asList(target, weight);
            List<List<Integer>> lists = adjustList.get(source);
            lists.add(tw);
            adjustList.put(source, lists);
        }

        //Already heap is added with start node
        while (!heap.isEmpty()){
            Integer currentVertex = heap.remove();
            List<List<Integer>> adjacent = adjustList.get(currentVertex);
            System.out.println("Current Vertex " + currentVertex + " list " + adjacent);
            for (List<Integer> integers : adjacent) {
                Integer neighborVertex = integers.get(0);
                Integer weight = integers.get(1);
                if (distanceMap.get(currentVertex) + weight < distanceMap.get(neighborVertex)) {
                    distanceMap.put(neighborVertex, distanceMap.get(currentVertex) + weight);
                }
                if(neighborVertex >= currentVertex)
                    heap.add(neighborVertex);
            }
            //System.out.println("inside for block");
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(distanceMap);
        System.out.println(distanceMap.size());
        int max = 0;
        for(int i = 1; i < distanceMap.size() + 1; i++){
            max = Math.max(max, distanceMap.get(i));
        }
        return (max == Integer.MAX_VALUE)? -1:max;
    }
}
