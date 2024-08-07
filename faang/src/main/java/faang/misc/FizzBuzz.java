package faang.misc;

public class FizzBuzz {

    //print Fizz if number is multiple of 3
    //print Buzz if number is multiple of 5
    //print FizzBuzz if number is multiple of 5 & 3

    public static void main(String[] args) {
        int n = 100;

        for(int i = 1; i <=100; i++){
            if(i%15 == 0){
                System.out.println(i + " FizzBuzz");
            } else if (i%5 == 0) {
                System.out.println(i + " Buzz");
            } else if (i%3 == 0){
                System.out.println(i + " Fizz");
            }
        }
    }


}
