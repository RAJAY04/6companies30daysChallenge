package day17;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class StoneGameIV {
    public static void main(String[] args) {
        int[] aliceValues = {9,8,3,8};
        int[] bobValues = {10,6,9,5};
        System.out.println(new StoneGameIV().stoneGameVI(aliceValues,bobValues));
    }

    static class Pair {
        int sum;
        int index;
        int aliceVal;
        int bobVal;

        Pair(int sum, int index, int aliceVal, int bobVal) {
            this.sum = sum;
            this.index = index;
            this.aliceVal = aliceVal;
            this.bobVal = bobVal;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->
                Integer.compare(p2.sum, p1.sum)
        );

        int n = aliceValues.length;
        for(int i = 0; i < n; i++) {
            int sum = aliceValues[i] + bobValues[i];
            pq.offer(new Pair(sum, i, aliceValues[i], bobValues[i]));
        }

        int aScore = 0, bScore = 0;
        boolean aliceTurn = true;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(aliceTurn) {
                aScore += aliceValues[p.index];
                aliceTurn = false;
            } else {
                bScore += bobValues[p.index];
                aliceTurn = true;
            }
        }

        return Integer.compare(aScore, bScore);
    }
}