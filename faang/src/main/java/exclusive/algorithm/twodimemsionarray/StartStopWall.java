package exclusive.algorithm.twodimemsionarray;

import java.util.Arrays;

public class StartStopWall {
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        char[][] charArray = new char[4][4];
        Arrays.stream(charArray).forEach(row->Arrays.fill(row,' '));
        charArray[0][2] = 'E';
        charArray[1][0] = 'S';
        charArray[1][1] = 'W';
        charArray[1][3] = 'W';
        charArray[2][1] = 'S';
        charArray[2][3] = 'W';
        charArray[3][1] = 'W';

        System.out.println(getNoOfSteps(charArray, 1, 0, 16, 1));
    }

    public static int getNoOfSteps(char[][] arr, int row, int col, int min, int count){
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length)
            return Math.min(min, count +1);
        if(arr[row][col] == 'E'){
            return Math.min(min, count +1);
        } else {
            for (int[] currentDirection : directions) {
                return getNoOfSteps(arr, row + currentDirection[0], col + currentDirection[1], min, count + 1);
            }
        }
        return count;
    }
}
