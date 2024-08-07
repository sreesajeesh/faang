package exclusive.algorithm;

public class RecursionType {

    public static void main(String[] args) {
        System.out.println(tailFactorial(4, 1));
    }

    public static int normalFactorial(int n){
        if(n <=1)
            return 1;
        else
            return n * normalFactorial(n - 1);
    }

    public static int tailFactorial(int n, int totalScore){
        if (n == 0)
            return totalScore;
        else
            return tailFactorial(n-1, totalScore * n);
    }
}
