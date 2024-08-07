package exclusive.algorithm.twodimemsionarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArrayDFS {

    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] twoDArrays =
                    {   {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20}
                    };
        System.out.println(Arrays.toString(traverse2DArrayDFS(twoDArrays).toArray()));
    }

    public static List<Integer> traverse2DArrayDFS(int[][] arr){
        int[][] checkedArray = new int[arr.length][arr[0].length];
        Arrays.stream(checkedArray).forEach(row->Arrays.fill(row,0));
        //nt[] values = new int[arr.length * arr[0].length];
        List<Integer> values = new ArrayList<>();
        dfs(arr,0,0, checkedArray, values);
        return values;
    }

    public static void dfs(int[][] arr, int row, int col, int[][] seen, List<Integer> values){
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || seen[row][col] == 1)
            return;
        values.add(arr[row][col]);
        seen[row][col] = 1;
        for (int[] currentDirection : directions) {
            dfs(arr, row + currentDirection[0], col + currentDirection[1], seen, values);
        }
    }
}
