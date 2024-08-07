package exclusive.algorithm.sorting;

import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args) {
        int [] arr = {5,3,1,6,4,2};
        System.out.println(getValueBySelect(arr, 4));
    }

    public static int getValueOfIndex(int[] arr, int index){
        int indexToFind = arr.length - index;
        quickSorts(arr, 0, arr.length - 1);
        return arr[indexToFind];
    }

    public static int getValueBySelect(int[] arr, int index){
        return quickSelect(arr, 0, arr.length - 1, index);
    }

    public static void quickSorts(int[] arr, int left, int right){
        if(left < right){
            int partitionIndex = partition(arr, left, right);
            quickSorts(arr, left, partitionIndex -1);
            quickSorts(arr, partitionIndex + 1, right);
        }
    }

    public static int quickSelect(int[] arr, int left, int right, int indexToFind){

        if(left < right){
            int partitionIndex = partition(arr, left, right);
            if(partitionIndex == indexToFind)
                return arr[partitionIndex];
            else if (indexToFind < partitionIndex)
                return quickSelect(arr, left, partitionIndex -1, indexToFind);
            else
                return quickSelect(arr, partitionIndex + 1, right, indexToFind);
        }
        return -1;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int partitionIndex = left;
        for(int index = left; index < right; index++){
            if(arr[index] < pivot){
                swap(arr, partitionIndex, index);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] =  arr[right];
        arr[right] = temp;
    }
}
