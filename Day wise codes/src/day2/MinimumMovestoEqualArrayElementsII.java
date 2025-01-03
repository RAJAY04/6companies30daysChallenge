package day2;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElementsII obj = new MinimumMovestoEqualArrayElementsII();
        System.out.println(obj.minMoves2(new int[] { 1, 2, 3 }));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = (n % 2 == 0) ? (nums[n/2] + nums[(n/2) - 1]) / 2 : nums[n / 2];
        int sum = 0;
        for(int num : nums){
            sum += Math.abs(median - num);
        }

        return sum;
    }
}
