package day26;

import java.util.HashSet;
import java.util.Set;

public class KDivisibleElementsSubarrays {
    public static void main(String[] args) {
        KDivisibleElementsSubarrays obj = new KDivisibleElementsSubarrays();
        int[] nums = {1,2,3,4};
        int k = 1;
        int p = 2;
        System.out.println(obj.countDistinct(nums,k,p));
    }

    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        int n = nums.length;

        for(int start = 0; start < n; start++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for(int end = start; end < n; end++) {
                if(nums[end] % p == 0) {
                    count++;
                }

                if(count > k) break;

                sb.append(nums[end]).append("_");
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
