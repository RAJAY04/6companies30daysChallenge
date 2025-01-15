package day14;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new TopKFrequentWords().topKFrequent(words, k));
    }

    static class Pair{
        String s;
        int count;
        Pair(String s, int count){
            this.s = s;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.count == p2.count) {
                    return p2.s.compareTo(p1.s);
                }
                return Integer.compare(p1.count, p2.count);
            }
        };

        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.merge(s,1,Integer::sum);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size() > k)pq.poll();
        }

        LinkedList<String> res = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){
            res.addFirst(pq.poll().s);
        }
        return res;
    }
}
