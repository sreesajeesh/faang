package exclusive.dojo;

import java.util.Arrays;
import java.util.OptionalInt;

public class RotationalArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5,6,7};
        int[] arr2 = new int[]{4,5,6,7,1,2,3};
        System.out.println(myCheckRotateArray(arr1, arr2));
    }

    public static boolean myCheckRotateArray(int[] arr1, int[] arr2){
        // get the index in second array which is equal to first element of first array
        int index = -1;
        OptionalInt optionalIndex = Arrays.stream(arr2).filter(i -> arr2[i-1] == arr1[0]).max();
        if(optionalIndex.isPresent()){
            index = optionalIndex.getAsInt() - 1;
        }
        System.out.println(index);
        //int nextIndex = 0;
        int i = 0;
        while(i < arr1.length){
//            if(index >= arr2.length){
//                index = 0;
//            }

//            if(arr1[i] == arr2[index]){
//                i++;
//                index++;
//                continue;
//            } else {
//                return false;
//            }
            int j = (index + i)% arr1.length;
            if(arr1[i] != arr2[j])
                return false;
            i++;
        }
        return true;
    }
}
