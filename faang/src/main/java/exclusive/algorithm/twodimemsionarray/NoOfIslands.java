package exclusive.algorithm.twodimemsionarray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NoOfIslands {

    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] arr = new int[4][5];
        Arrays.stream(arr).forEach(row->Arrays.fill(row, 1));
        arr[0][4] = 0;
        arr[1][2] = 0;
        arr[1][4] = 0;
        arr[2][2] = 0;
        arr[2][3] = 0;
        arr[3][0] = 0;
        arr[3][1] = 0;
        arr[3][2] = 0;
        System.out.println(getNoOfIslands(arr));
    }

    public static int getNoOfIslands(int[][] arr){
        int islandCount = 0;
        for(int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[0].length; col++){
                if(arr[row][col] == 1){
                    islandCount++;
                    arr[row][col] = 0;
                    Queue<RowCol> queue = new ArrayDeque<>();
                    queue.add(new RowCol(row, col));
                    while (!queue.isEmpty()){
                        RowCol currentPos = queue.remove();
                        for(int i = 0; i < directions.length; i++){
                            int nextRow = currentPos.row + directions[i][0];
                            int nextCol = currentPos.col + directions[i][1];
                            if(nextRow < 0 || nextRow >= arr.length
                                || nextCol < 0 || nextCol >= arr[0].length){
                                continue;
                            }
                            if(arr[nextRow][nextCol] == 1){
                                queue.add(new RowCol(nextRow, nextCol));
                                arr[nextRow][nextCol] = 0;
                            }
                        }
                    }
                }
            }
        }
        return islandCount  ;
    }
}
