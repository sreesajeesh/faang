package exclusive.sample1;

public class NumberMultiplocation {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        // n =4
        //1111
        //121
        //112
        //211
        //22
        //n =1 1
        //n = 2 2
        // n =3 3
        //n =4 5
        //n-5 8


    }

    public static int noOfSteps(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n > 2){
            return noOfSteps(n -1 ) + noOfSteps(n -2);
        }
        return 0;

    }
}
