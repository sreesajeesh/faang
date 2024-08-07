package exclusive.algorithm.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class DependentCourses {

    public static void main(String[] args) {
        List<List<Integer>> courses = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> courseMap = new HashMap<>();
        HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
        int[] inDegree;
        int maxSize = 0;

        List<Integer> courselist = Arrays.asList(1,0);
        courses.add(courselist);
        courselist = Arrays.asList(2,1);
        courses.add(courselist);
        courselist = Arrays.asList(2,5);
        courses.add(courselist);
        courselist = Arrays.asList(0,3);
        courses.add(courselist);
        courselist = Arrays.asList(4,3);
        courses.add(courselist);
        courselist = Arrays.asList(3,5);
        courses.add(courselist);
        courselist = Arrays.asList(4,5);
        courses.add(courselist);
        for (List<Integer> lists : courses) {
            maxSize = Math.max(maxSize, Math.max(lists.get(0), lists.get(1)));
        }
        inDegree = new int[maxSize + 1];
        Arrays.fill(inDegree,0);
        for (List<Integer> courseDependent : courses) {
            inDegree[courseDependent.get(0)]++;
        }
        for(int i = 0; i < inDegree.length; i++){
            inDegreeMap.put(i, inDegree[i]);
        }
        for(int i = 0; i < maxSize + 1; i++){
            System.out.println(inDegree[i]);
        }
        for(int i = 0; i < maxSize + 1; i++){
            ArrayList<Integer> dependent = new ArrayList<>();
            courseMap.put(i, dependent);
        }
        for (List<Integer> courseDependent : courses) {
            ArrayList<Integer> dependent = courseMap.get(courseDependent.get(1));
            dependent.add(courseDependent.get(0));
            courseMap.put(courseDependent.get(1), dependent);
        }
        for(int i = 0; i < courseMap.size(); i++){
            System.out.println(i + " " + courseMap.get(i));
        }
        System.out.println(checkCyclicOptimum(courseMap, inDegreeMap));
    }

    public static Integer getKeyByValue(HashMap<Integer, Integer> inDegreeMap){
        for(Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()){
            if(Objects.equals(0, entry.getValue())){
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean checkCyclicOptimum(HashMap<Integer, ArrayList<Integer>> courseMap, HashMap<Integer,Integer> inDegree){
        boolean[] seen = new boolean[inDegree.size()];
        int count = courseMap.size();
        while (count > 0) {
            Integer key = getKeyByValue(inDegree);
            inDegree.remove(key);
            if(inDegree.isEmpty()){
                System.out.println("Count = " + count);
                return true;
            }
            ArrayList<Integer> list = courseMap.get(key);
            for(Integer data : list){
                Integer value = inDegree.get(data);
                inDegree.put(data, value-1);
            }
            count--;
        }
        return false;
    }
    public static boolean checkCyclic(HashMap<Integer, ArrayList<Integer>> courseMap){
        for(int i = 0; i < courseMap.size(); i++){
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] seen = new boolean[courseMap.size()];
            //queue.addAll(courseMap.get(i));
            for(int j = 0; j < courseMap.size(); j++){
                if(courseMap.get(i) != null) {
                    List<Integer> list = courseMap.get(i);
                    queue.addAll(list);
                }
            }
            while (!queue.isEmpty()){
                Integer current = queue.remove();
                seen[current] = true;
                if(current == i) return false;
                List<Integer> adjacent = courseMap.get(current);
                if(adjacent != null) {
                    for (Integer next : adjacent) {
                        if (!seen[next])
                            queue.add(next);
                    }
                }
            }
        }
        return true;
    }
}
