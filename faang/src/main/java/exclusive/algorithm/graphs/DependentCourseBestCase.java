package exclusive.algorithm.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DependentCourseBestCase {

    public static void main(String[] args) {
        List<List<Integer>> courses = new ArrayList<>();
        List<Integer> courselist = Arrays.asList(1,0);
        HashMap<Integer, ArrayList<Integer>> courseMap = new HashMap<>();
        int[] inDegree;
        int maxSize = 0;
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
        System.out.println(courses);
        for (List<Integer> lists : courses) {
            maxSize = Math.max(maxSize, Math.max(lists.get(0), lists.get(1)));
        }
        inDegree = new int[maxSize + 1];
        Arrays.fill(inDegree, 0);
        for(int i = 0; i < maxSize + 1; i++){
            ArrayList<Integer> dependent = new ArrayList<>();
            courseMap.put(i, dependent);
        }
        for (List<Integer> pair : courses) {
            inDegree[pair.get(0)]++;
            ArrayList<Integer> dependent = courseMap.get(pair.get(1));
            dependent.add(pair.get(0));
            courseMap.put(pair.get(1), dependent);
        }
        for(int i = 0; i < courseMap.size(); i++){
            System.out.print(i + " " + courseMap.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < maxSize + 1; i++){
            System.out.print(inDegree[i] + " ");
        }

        System.out.println(checkAcyclic(inDegree, courseMap));
    }

    public static boolean checkAcyclic(int[] inDegree, HashMap<Integer, ArrayList<Integer>> courseMap){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < courseMap.size(); i++){
            if(inDegree[i] == 0){
                stack.push(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()){
            int current = stack.pop();
            count++;
            List<Integer> adjcentList = courseMap.get(current);
            if(adjcentList.isEmpty()) continue;
            for(Integer vertex : adjcentList){
                inDegree[vertex]--;
                if(inDegree[vertex] == 0){
                    stack.push(vertex);
                }
            }
        }
        return count == courseMap.size();
    }
}
