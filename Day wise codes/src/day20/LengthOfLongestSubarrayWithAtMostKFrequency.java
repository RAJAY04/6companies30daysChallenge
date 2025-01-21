package day20;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        LengthOfLongestSubarrayWithAtMostKFrequency obj = new LengthOfLongestSubarrayWithAtMostKFrequency();
        int[] nums = {1,2,1,2,1,2,1,2,1};
        int k = 2;
        System.out.println(obj.maxSubarrayLength(nums,k));
    }
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0 , j = 0;
        int maxLen = 0;
        while(j < n){
            map.merge(nums[j],1,(a,b) -> a + b);
            while(i < n && (map.get(nums[j]) > k)){
                map.put(nums[i],map.get(nums[i]) - 1);
                // if(map.get(nums[i]) == 0)map.remove(nums[i]);
                i++;
            }
            maxLen = Math.max(maxLen,(j - i + 1));
            j++;
        }
        return maxLen;
    }
}
