package exclusive.algorithm.dp;

import java.util.Arrays;

public class KnightMoves {

    static int[][] directions = { {-2, -1}, {-2, 1}, {-1, 2}, {1,2}, {2,-1}, {2,1}, {1,-2}, {-1,-2}};

    public static void main(String[] args) {
        int noOfSquares = 6;
        int knight = 2;
        int rowPos = 2;
        int colPos = 2;
        System.out.println(knightProbabilityDP(noOfSquares, knight, rowPos, colPos));

    }

    public static float knightProbability(int num, int knight, int row, int col){
            if(row < 0 || row >= num || col < 0 || col >= num){
                return 0;
            }
            if(knight == 0){
                return 1;
            }
            float result = 0;
            for(int[] dir : directions){
                result += knightProbability(num, knight-1, row + dir[0], col + dir[1])/8;
            }
            return result;
    }

    public static float knightProbabilityDP(int num, int knight, int row, int col){
        float[][][] dp = new float[knight + 1][num][num];
        for(float[][] rows : dp){
            for(float[] cols : rows){
                Arrays.fill(cols, Float.MIN_VALUE);
            }
        }
        return recursive(num, knight, row, col, dp);
    }

    public static float recursive(int num, int knight, int row, int col, float[][][] dp){
        if(row < 0 || row >= num || col < 0 || col >= num){
            return 0;
        }
        if(knight == 0){
            return 1;
        }
        if(dp[knight][row][col] != Float.MIN_VALUE)
            return dp[knight][row][col];
        float result = 0;
        for(int[] dir : directions){
            result += recursive(num, knight - 1, row + dir[0], col + dir[1], dp )/8;
        }
        dp[knight][row][col] = result;
        return dp[knight][row][col];
    }
}
