package exclusive.algorithm.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MinTimeNetworkBellman {

    public static void main(String[] args) {

        List<List<Integer>> network = new ArrayList<>();
        network.add(Arrays.asList(1,2,9));
        network.add(Arrays.asList(1,4,2));
        network.add(Arrays.asList(2,5,-3));
        network.add(Arrays.asList(4,2,-4));
        network.add(Arrays.asList(4,5,6));
        network.add(Arrays.asList(3,2,3));
        network.add(Arrays.asList(5,3,7));
        network.add(Arrays.asList(3,1,5));

        System.out.println(negativeNetworkDelay(network, 5, 1));

    }

    public static int negativeNetworkDelay(List<List<Integer>> times, int nodes, int startNode){
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
//        HashMap<Integer, List<List<Integer>>> adjustList = new HashMap<>();
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)-> distanceMap.get(a) - distanceMap.get(b));
        for (int i = 1; i <= nodes; i++){
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(startNode, 0);
        for(int i = 1; i < nodes -1 - 1; i++){
            int count = 0;
            for (List<Integer> time : times) {
                Integer source = time.get(0);
                Integer target = time.get(1);
                Integer weight = time.get(2);
                if (distanceMap.get(source) + weight < distanceMap.get(target)) {
                    distanceMap.put(target, distanceMap.get(source) + weight);
                    count++;
                }
            }
            if(count == 0) break;
        }
        int answer = 0;
        for(int i = 1; i < distanceMap.size() + 1; i++){
            answer = Math.max(answer, distanceMap.get(i));
            System.out.println(distanceMap.get(i));
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
