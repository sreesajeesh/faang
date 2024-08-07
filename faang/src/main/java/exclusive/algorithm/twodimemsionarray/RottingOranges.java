package exclusive.algorithm.twodimemsionarray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {

    static int ROTTEN = 2;
    static int FRESH = 1;
    static int EMPTy = 0;
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] arr = new int[4][5];
        Arrays.stream(arr).forEach(row -> Arrays.fill(row,1));
        arr[0][0] = 2;
        //arr[0][1] = 0;
        //arr[0][2] = 0;
        arr[0][4] = 0;
        arr[1][3] = 0;
        arr[1][4] = 2;
        arr[2][0] = 0;
        arr[3][0] = 0;
        arr[3][2] = 0;
        arr[3][3] = 0;

        System.out.println(getTime(arr));
    }

    public static int getTime(int[][] arr){
        if(arr.length == 0) return 0;
        Queue<RowCol> rotQueue = new ArrayDeque<>();
        int freshCount = 0;
        int minuteCount = 0;
        for(int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == ROTTEN) {
                    rotQueue.add(new RowCol(row, col));
                }
                if(arr[row][col] == FRESH)
                    freshCount++;
            }
        }
        System.out.println("Fresh Orange = " + freshCount);
        int currentQueueSize = rotQueue.size();
        while (!rotQueue.isEmpty()){
            if (currentQueueSize == 0){
                minuteCount++;
                currentQueueSize = rotQueue.size();
            }
            RowCol currentPos = rotQueue.remove();
            currentQueueSize--;
            for (int[] direction : directions) {
                int nextRow = currentPos.row + direction[0];
                int nextCol = currentPos.col + direction[1];
                if (nextRow < 0 || nextRow >= arr.length
                        || nextCol < 0 || nextCol >= arr[0].length) {
                    continue;
                }
                if (arr[nextRow][nextCol] == FRESH) {
                    arr[nextRow][nextCol] = ROTTEN;
                    freshCount--;
                    rotQueue.add(new RowCol(nextRow, nextCol));
                }
            }
        }
        System.out.println("Fresh count after " + freshCount);
        if(freshCount > 0)
            return -1;
        return minuteCount;
    }

    public static int getTimeByMe(int[][] arr){
        if(arr.length == 0) return 0;
        Queue<RowCol> rotQueue = new ArrayDeque<>();
        int rotCount = 0;
        int freshCount = 0;
        int minuteCount = 0;
        Queue<RowCol> tempRotQueue = new ArrayDeque<>();
        for(int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == 2) {
                    rotQueue.add(new RowCol(row, col));
                } else
                    freshCount++;
            }
        }
        while (!rotQueue.isEmpty()){
            // once queue is empty then increment minute count.

            RowCol currentPos = rotQueue.remove();
            for (int[] direction : directions) {
                int nextRow = currentPos.row + direction[0];
                int nextCol = currentPos.col + direction[1];
                if (nextRow < 0 || nextRow >= arr.length
                        || nextCol < 0 || nextCol >= arr[0].length) {
                    continue;
                }
                if (arr[nextRow][nextCol] == 1) {
                    tempRotQueue.add(new RowCol(nextRow, nextCol));
                    arr[nextRow][nextCol] = 2;
                    freshCount--;
                }
            }
            if(rotQueue.isEmpty()){
                if(!tempRotQueue.isEmpty())
                    rotQueue.addAll(tempRotQueue);
                minuteCount++;
                tempRotQueue.clear();
            }
        }
        if(freshCount > 0)
            return -1;
        return minuteCount;
    }
}
