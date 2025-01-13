package day12;

import java.util.*;

public class KDiffPairInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 1;
        System.out.println(findPairs(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        Set<Integer> ele = new HashSet<>();
        Set<List<Integer>> pairs = new HashSet<>();

        for(int num : nums) {
            if(ele.contains(num + k)) {
                List<Integer> arr = Arrays.asList(num, num + k);
                pairs.add(arr);
            }
            if(ele.contains(num - k)) {
                List<Integer> arr = Arrays.asList(Math.min(num, num - k), Math.max(num, num - k));
                pairs.add(arr);
            }
            ele.add(num);
        }
        return pairs.size();
    }
}
