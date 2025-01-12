package day11;

import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    public static void main(String[] args) {
        FindSubsequenceOfLengthKWithTheLargestSum obj = new FindSubsequenceOfLengthKWithTheLargestSum();
        int[] nums = {1, 4, 3, 2, 5};
        int k = 3;
        int[] res = obj.maxSubsequence(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0 ; i < n; i++){
            pq.offer(new int[]{nums[i],i});
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int i = 0 ; i < k ;i++){
            pq2.offer(pq.poll());
        }
        int[] res = new int[k];
        for(int i = 0 ; i < k ;i++){
            res[i] = pq2.poll()[0];
        }
        return res;
    }
}
