package exclusive.algorithm.twodimemsionarray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class TwoDArrayBFS {

    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] twoDArrays =
                    {   {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20}
                    };
        System.out.println(Arrays.toString(traverse2DArrayBFS(twoDArrays).toArray()));
    }

    public static List<Integer> traverse2DArrayBFS(int[][] arr){
        int[][] checkedArray = new int[arr.length][arr[0].length];
        Arrays.stream(checkedArray).forEach(row->Arrays.fill(row,0));
        //nt[] values = new int[arr.length * arr[0].length];
        List<Integer> values = new ArrayList<>();
        Queue<RowCol> rowColQueue = new ArrayDeque<>();
        RowCol rowCol = new RowCol(0, 0);
        rowColQueue.add(rowCol);
        while (!rowColQueue.isEmpty()){
            RowCol rc = rowColQueue.remove();
            if(rc.row < 0 || rc.row >= arr.length || rc.col < 0 || rc.col >= arr[0].length || checkedArray[rc.row][rc.col] == 1){
               continue;
            }
            checkedArray[rc.row][rc.col] = 1;
            values.add(arr[rc.row][rc.col]);
            for (int[] currentDirection : directions) {
                rowColQueue.add(new RowCol(rc.row + currentDirection[0], rc.col + currentDirection[1]));
            }
        }
        return values;
    }

}
