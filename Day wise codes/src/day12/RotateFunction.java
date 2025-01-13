package day12;

public class RotateFunction {
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int max = 0;
        int factor = 0,sum = 0;
        int product = 0;
        for(int i = 0 ; i < n; i++){
            if(i > 0)sum += nums[i];
            product += (factor * nums[i]);
            factor++;
        }
        max = product;
        for(int i = 0 ; i < n - 1; i++){
            product = product - sum + (nums[i] * (n - 1));
            sum += nums[i];
            sum -= nums[i + 1];
            max = Math.max(max, product);
        }
        return max;
    }
}
