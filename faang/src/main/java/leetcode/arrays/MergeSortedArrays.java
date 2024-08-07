package leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {

        int[] m = new int[]{4,0,0,0,0,0};
        int[] n = new int[]{1,2,3,5,6};
        getSorted(m,1,n,5);
    }

    public static int[] mergeArray(int[] num1, int[] num2){
        int p1 = num1.length -1, p2 = num2.length - 1;
        num1 = Arrays.copyOf(num1, num1.length + num2.length);
        int i = num1.length - 1;
        while (i >= 0 && p2 >= 0 && p1 >= 0){
            if(num2[p2] > num1[p1]){
                num1[i] = num2[p2];
                i--;
                p2--;
            } else {
                num1[i] = num1[p1];
                num1[p1] = num2[p2];
                i--;
                p2--;
                p1--;
            }
        }
        return num1;
    }

    public static int[] mergeArray(int[] nums1, int m, int[] nums2, int n){
        int i = nums1.length - 1;
        if(m == 0 && i == 0){
            nums1[0] = nums2[0];
        } else {
            if(m > 0){
                m = m - 1;
            }
            n = n - 1;
            while (i >= 0 && n >= 0 && m >= 0) {
                if (nums2[n] > nums1[m]) {
                    nums1[i] = nums2[n];
                    n--;
                    i--;
                } else {
                    nums1[i] = nums1[m];
                    nums1[m] = nums2[n];
                    i--;
                    m--;
                    n--;
                }
            }
        }
        return nums1;
    }

    public static void getSorted(int[] nums1, int m, int[] nums2, int n){
        int p1 = m -1;
        int p2 = n -1;
        for (int i = nums1.length-1; i >= 0 ; i--) {
            int valueAtP1 = p1 >= 0? nums1[p1] : Integer.MIN_VALUE;
            int valueAtP2 = p2 >= 0? nums2[p2] : Integer.MIN_VALUE;
            if(valueAtP1 > valueAtP2){
                nums1[i] = valueAtP1;
                p1--;
            } else {
                nums1[i] = valueAtP2;
                p2--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
