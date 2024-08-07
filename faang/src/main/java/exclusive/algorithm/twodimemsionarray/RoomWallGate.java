package exclusive.algorithm.twodimemsionarray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Queue;

public class RoomWallGate {

    static int EMPTY = Integer.MAX_VALUE;
    static int WALL = -1;
    static int GATE = 0;
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Arrays.stream(arr).forEach(row->Arrays.fill(row, EMPTY));
        arr[0][1] = WALL;
        arr[0][2] = GATE;
        arr[1][3] = WALL;
        arr[2][1] = WALL;
        arr[2][3] = WALL;
        arr[3][0] = GATE;
        arr[3][1] = WALL;
        getShortSteps(arr);
    }

    public static void getShortSteps(int[][] arr){

        for(int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if(arr[row][col] == GATE){
                    //call function to find minimumSteps for each empty room to gate
                    findMinimumSteps(arr, row, col);
                }
            }
        }
        for(int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
            }
    }

    public static void findMinimumSteps(int[][] arr, int row, int col){
        Queue<RowCol> stepQueue = new ArrayDeque<>();
        stepQueue.add(new RowCol(row, col));
        while (!stepQueue.isEmpty()) {
            RowCol currentPos = stepQueue.remove();
            for (int[] direction : directions) {
                int nextRow = currentPos.row + direction[0];
                int nextCol = currentPos.col + direction[1];
                if (nextRow < 0 || nextRow >= arr.length
                        || nextCol < 0 || nextCol >= arr[0].length) {
                    continue;
                }
                if (arr[nextRow][nextCol] > arr[currentPos.row][currentPos.col]) {
                    arr[nextRow][nextCol] = arr[currentPos.row][currentPos.col] + 1;
                    stepQueue.add(new RowCol(nextRow, nextCol));
                }
            }
        }
    }
}
