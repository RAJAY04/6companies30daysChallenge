package day6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(new MaximumSumofDistinctSubarraysWithLengthK().maximumSubarraySum(nums,k));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> dup = new HashSet<>();

        int n = nums.length;
        int i = 0 , j = 0 ;
        long ans = 0;
        long sum = 0;
        while(j < n){
            while(i < n && (j - i + 1) == k){
                if(dup.isEmpty())ans = Math.max(sum,ans);
                map.put(nums[i],map.getOrDefault(nums[i],0) - 1);
                if(map.get(nums[i]) == 1)dup.remove(nums[i]);
                if(map.get(nums[i]) == 0)map.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            sum += nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0) + 1);
            if(map.get(nums[j])  == 2)dup.add(nums[j]);
            j++;
        }
        return ans;
    }
}
