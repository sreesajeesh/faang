package leetcode.arrays;

public class JumpGame {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,0,4};
        System.out.println(jump(arr));
    }

    public static boolean jump(int[] nums){
        int reachable = 0;
        int count = 0;
        for (int i = 0; i < nums.length && i <= reachable; i++) {
            count++;
            reachable = Math.max(reachable, i + nums[i]);
            System.out.println(count);
            if(reachable >= nums.length - 1)
                return  true;
        }
        return false;
    }
}
