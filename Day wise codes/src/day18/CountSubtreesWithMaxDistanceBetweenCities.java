package day18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountSubtreesWithMaxDistanceBetweenCities {

    private List<List<Integer>> graph;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] result = new int[n - 1];

        for (int mask = 3; mask < (1 << n); mask++) {
            int maxDist = getMaxDistance(mask, n);
            if (maxDist > 0) {
                result[maxDist - 1]++;
            }
        }

        return result;
    }

    private static class BFSResult {
        int farthestNode;
        int maxDistance;
        int visitedCount;

        BFSResult(int node, int dist, int count) {
            farthestNode = node;
            maxDistance = dist;
            visitedCount = count;
        }
    }

    private BFSResult bfs(int start, int mask, int totalNodes) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        int visited = 1 << start;
        int visitedCount = 1;
        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = node;
            }

            for (int neighbor : graph.get(node)) {
                int neighborBit = 1 << neighbor;
                if ((mask & neighborBit) != 0 && (visited & neighborBit) == 0) {
                    visited |= neighborBit;
                    visitedCount++;
                    queue.offer(new int[]{neighbor, distance + 1});
                }
            }
        }

        return new BFSResult(farthestNode, maxDistance, visitedCount);
    }

    private int getMaxDistance(int mask, int n) {
        int nodeCount = Integer.bitCount(mask);
        if (nodeCount <= 1) return 0;
        int start = 0;
        while ((mask & (1 << start)) == 0) start++;
        BFSResult firstBFS = bfs(start, mask, nodeCount);
        if (firstBFS.visitedCount != nodeCount) return -1;
        BFSResult secondBFS = bfs(firstBFS.farthestNode, mask, nodeCount);
        return secondBFS.maxDistance;
    }
}
