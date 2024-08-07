package faang.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

    //DynamicSlidingWindow
    public static void main(String[] args) {
        int[] fruitTrees = new int[] {0, 1, 6, 6, 4, 7, 6};

        System.out.println(findFruits(fruitTrees));

    }

    public static int findFruits(int[] trees){
        Map<Integer, Boolean> treeMap = new HashMap<>();
        int max = 0;
        int start = 0;
        int end = 0;

        for(int treeType : trees){
            if(treeMap.size() < 2 && !treeMap.containsKey(treeType)){
                treeMap.put(treeType, Boolean.TRUE);
                max = Math.max(max, end-start+1);
            } else if (treeMap.containsKey(treeType)) {
                max = Math.max(max, end-start+1);
            } else {
                treeMap = new HashMap<>();
                treeMap.put(trees[end-1], true);
                treeMap.put(treeType, true);
                start = end - 1;
                while (trees[start] == trees[start-1]){
                    start--;
                }
                max = Math.max(max, end-start+1);
            }
            end++;
        }
        return max;
    }
}
