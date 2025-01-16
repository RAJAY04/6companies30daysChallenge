package day15;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    static class Pair{
        Character c;
        int count;
        Pair(Character c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.merge(c,1,Integer::sum);
        }
        Comparator<Pair> comparator = (p1, p2) ->{
            return p2.count - p1.count;
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            while(p.count-- > 0){
                sb.append(p.c);
            }
        }
        return sb.toString();
    }
}
