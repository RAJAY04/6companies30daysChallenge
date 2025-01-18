package day17;

import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 5;
        System.out.println(new MaximumProductAfterKIncrements().maximumProduct(nums,k));
    }
    static int MOD = (int)(1e9) + 7;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
        }
        int product = 1;
        for(int i = 0 ; i < k ; i++){
            pq.offer(pq.poll() + 1);
        }
        while(!pq.isEmpty()){
            product = (int)(((long)product * pq.poll()) % MOD);
        }
        return product % MOD;

    }
}
