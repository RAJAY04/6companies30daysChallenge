package day3;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int ans = 0;
        for(int num : nums){
            preSum += num % 2 == 0 ? 0 : 1;
            ans += map.getOrDefault(preSum - k,0);
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }
}
