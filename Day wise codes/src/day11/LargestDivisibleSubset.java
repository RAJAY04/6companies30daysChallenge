package day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
    }

    List<Integer> res;
    int[] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        memo(nums,0,1,ans);
        return res;
    }

    public void memo(int[] nums,int i , int prev, List<Integer> ans){
        if(i >= nums.length){
            if(ans.size() > res.size()){
                res.clear();
                res.addAll(ans);
            }
            return;
        }

        if(dp[i] < ans.size() && (prev % nums[i] == 0 || nums[i] % prev == 0)){
            dp[i] = ans.size();
            ans.add(nums[i]);
            memo(nums,i + 1, nums[i],ans);
            ans.remove(ans.size() - 1);
        }
        memo(nums,i + 1, prev,ans);
    }
}
