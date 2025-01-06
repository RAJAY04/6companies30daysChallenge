package day5;

import java.util.*;

public class MinimumCosttoConvertStringI {
    public static void main(String[] args) {
        String source = "abc";
        String target = "bcd";
        char[] original = {'a', 'b', 'c'};
        char[] changed = {'b', 'c', 'd'};
        int[] cost = {1, 2, 3};
        System.out.println(minimumCost(source, target, original, changed, cost));
    }

    static class Pair implements Comparable<Pair> {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < original.length; i++) {
            int node = original[i] - 'a';
            int adjNode = changed[i] - 'a';
            adj.get(node).add(new Pair(cost[i], adjNode));
        }

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : source.toCharArray()) uniqueChars.add(c);
        for (char c : target.toCharArray()) uniqueChars.add(c);

        Map<Integer, int[]> distancesMap = new HashMap<>();
        for (char c : uniqueChars) {
            int srcNode = c - 'a';
            distancesMap.put(srcNode, dikstras(adj, srcNode));
        }

        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int srcNode = source.charAt(i) - 'a';
            int tgtNode = target.charAt(i) - 'a';
            int distance = distancesMap.get(srcNode)[tgtNode];
            if (distance == Integer.MAX_VALUE) return -1;
            res += distance;
        }
        return res;
    }

    public static int[] dikstras(List<List<Pair>> adj, int srcNode) {
        int[] distance = new int[26];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, srcNode));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[srcNode] = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int wt = p.distance;
                if (distance[node] + wt < distance[adjNode]) {
                    distance[adjNode] = distance[node] + wt;
                    queue.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }
}
