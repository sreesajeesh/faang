package newproject.entity;

public class LongestSubsequence {

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,9,10, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22};
        int count = 0;
        int index = 0;
        int oldIndex = 0;
        int i = 0;
        int j = 1;
        int max = 0;
        while(i < arr.length - 1){
            if((arr[i] + 1) == arr[j]){
                    count++;
            } else {
                if(count > max) {
                    max = count;
                    count = 0;
                    oldIndex = index;
                }
                index = i + 1;
            }
            i++;
            j++;
        }
        System.out.println("First Index = " + oldIndex);
        System.out.println("Max count : " + max);
        for(int k = oldIndex; k < oldIndex + max; k++){
            System.out.println(arr[k]);
        }
    }

}
