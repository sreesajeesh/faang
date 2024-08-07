package leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args) {
        System.out.println(getSequence2(100, 300));
    }

    public static List<Integer> getSequentialDigit(int low, int high) {
        List<Integer> intList = new LinkedList<>();
        //Get the first Digit of low and high and number of digits of both and low
        int lowFirstDigit = Integer.parseInt(Integer.toString(low).substring(0, 1));
        int highFirstDigit = Integer.parseInt(Integer.toString(high).substring(0, 1));
        int lowLength = Integer.toString(low).length();
        int highLength = Integer.toString(high).length();

        int nextInt = 0;
        while (true) {
            for (int i = 0; i < lowLength; i++) {
                if (lowFirstDigit < 10) {
                    nextInt = nextInt * 10 + lowFirstDigit;
                    lowFirstDigit++;
                }
            }
            if ((nextInt >= low) && (nextInt <= high))
                intList.add(nextInt);
            else
                break;
            lowFirstDigit = Integer.parseInt(Integer.toString(nextInt).substring(0, 1)) + 1;
            nextInt = 0;
        }
        nextInt = 0;
        if (highLength > lowLength) {
            highFirstDigit = 1;
            while (true) {
                for (int i = 0; i < highLength; i++) {
                    if (highFirstDigit < 10) {
                        nextInt = nextInt * 10 + highFirstDigit;
                        highFirstDigit++;
                    }
                }
                if ((nextInt <= high))
                    intList.add(nextInt);
                else
                    break;
                highFirstDigit = Integer.parseInt(Integer.toString(nextInt).substring(0, 1)) + 1;
                nextInt = 0;
            }
        }
        return intList;
    }

    public static List<Integer> getSequenceDigitList(int low, int high) {
        String intString = "123456789";
        List<Integer> intList = new LinkedList<>();
        int lowLength = Integer.toString(low).length();
        int highLength = Integer.toString(high).length();
        int lowFirstDigit = Integer.parseInt(Integer.toString(low).substring(0, 1));
        int index = intString.indexOf(lowFirstDigit + "");

        for (int i = 0; i < lowLength; i++) {
            while (true) {
                if (index + lowLength <= intString.length()) {
                    int value = Integer.parseInt(intString.substring(index, index + lowLength));
                    if (value >= low && value <= high) {
                        intList.add(value);
                    }
                } else {
                    break;
                }
                index++;
            }
        }

        if (highLength > lowLength) {
            int diff = highLength - lowLength;
            int count = 1;

            while (count <= diff) {
                index = 0;
                for (int i = 0; i < lowLength + count; i++) {
                    while (true) {
                        if (index + lowLength + count <= intString.length()) {
                            int value = Integer.parseInt(intString.substring(index, index + lowLength + count));
                            if (value <= high) {
                                intList.add(value);
                            }
                        } else
                            break;
                        index++;
                    }
                }
                count++;
            }
        }
        return intList;
    }

    public static List<Integer> getSequence(int low, int high){
        String intString = "123456789";
        List<Integer> intList = new ArrayList<>();
        boolean flag = true;
        for(int i = 1; i <= 9; i++){
            for(int j = 0; i + j <= 9; j++){
                int value = Integer.parseInt(intString.substring(j, i + j));
                if(value > high){
                    flag = false;
                    break;
                }
                if(value < low)
                    continue;
                if(value >= low && value <= high)
                    intList.add(value);

            }
            if(!flag)
                break;
        }
        return intList;
    }

    public static List<Integer> getSequence2(int low, int high){
        String intString = "123456789";
        List<Integer> intList = new ArrayList<>();
        int lowLength = Integer.toString(low).length();
        int highLength = Integer.toString(high).length();
        int lowFirstDigit = Integer.parseInt(Integer.toString(low).substring(0, 1));
        int value;
        boolean flag = true;
        for(int i = lowFirstDigit - 1; i <= 9; i++){
            if (i + lowLength <= intString.length()) {
                value = Integer.parseInt(intString.substring(i, i + lowLength));
                if (value >= low && value <= high)
                    intList.add(value);
                if (value > high) {
                    break;
                }
            }
        }
        if(highLength > lowLength){
            int diff = highLength - lowLength;
            int count = 1;
            while(count <= diff){
                for(int i = 0; i <= 9; i++){
                    if((i + lowLength + count) <= intString.length() ){
                        value = Integer.parseInt(intString.substring(i, i + lowLength + count));
                        if (value <= high)
                            intList.add(value);
                        if (value > high) {
                            break;
                        }
                    }
                }
                count++;
            }
        }
        return intList;
    }
}

/*
System.out.println("First digit of low : " + lowFirstDigit);
        System.out.println("First digit of high : " + highFirstDigit);
        System.out.println("Length of low : " + lowLength);
        System.out.println("Length of high : " + highLength);
 */