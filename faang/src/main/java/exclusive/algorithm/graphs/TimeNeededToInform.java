package exclusive.algorithm.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TimeNeededToInform {

    public static NormalGraph normalGraph;

    public static void main(String[] args) {
        int[] manager = new int[]{2,2,4,6,-1,4,4,5};
        int[] informTime = new int[]{0,0,4,0,7,3,6,0};
        System.out.println(Arrays.toString(informTime));
        normalGraph = new NormalGraph(manager.length);
        createGraph(manager, normalGraph);
        for(int i = 0; i < manager.length; i++){
            System.out.println(normalGraph.dependent[i]);
        }
        System.out.println(maxTimeNeeded(4, normalGraph, informTime));

        //using Map
    //    System.out.println(maxTimeNeededUsingMap(manager, informTime));

    }

    public static int maxTimeNeededUsingMap(int[] manager, int[] informTime){
        HashMap<Integer, ArrayList<Integer>> dependent = new HashMap<>();
        int headId = 0;
        //Generate hashmap using manager element as key
        for(int i = 0; i < manager.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            dependent.put(i, list);
        }
        //Add list of dependent on each manager.
        for(int i = 0; i < manager.length; i++){
            if(manager[i] == -1) {
                headId = i;
                continue;
            }
            ArrayList<Integer> list = dependent.get(manager[i]);
            list.add(i);
            dependent.put(manager[i], list);
        }
        System.out.println(dependent);
        // Call dff algorithm to get max time to inform
        return dfsUsingMap(headId, dependent, informTime);
    }

    public static int dfsUsingMap(int headId, HashMap<Integer, ArrayList<Integer>> empMap, int[] informTime){
        int maxTime = 0;
        if(empMap.isEmpty()) return 0;
        ArrayList<Integer> subordinate = empMap.get(headId);
        for(Integer node : subordinate){
            maxTime = Math.max(maxTime, dfsUsingMap(node, empMap, informTime));
        }
        return maxTime + informTime[headId];
    }
    public static void createGraph(int[] manager, NormalGraph normalGraph){
        for(int i = 0; i < manager.length; i++){
            if(manager[i] == -1)
                continue;
            normalGraph.dependent[manager[i]].add(i);
        }
    }

    public static int maxTimeNeeded(int headId, NormalGraph normalGraph, int[] informTime){
        int maxTime = 0;
        if(normalGraph.dependent[headId].isEmpty())
            return 0;
        LinkedList<Integer> subordinate = normalGraph.dependent[headId];
        for(Integer node : subordinate){
            maxTime = Math.max(maxTime, maxTimeNeeded(node, normalGraph, informTime));
        }
        return maxTime + informTime[headId];
    }
}
