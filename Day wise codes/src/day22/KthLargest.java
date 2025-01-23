package day22;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        initialize(nums,k);
    }

    public void initialize(int[] nums,int k){
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k)pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)pq.poll();
        return pq.peek();
    }
}