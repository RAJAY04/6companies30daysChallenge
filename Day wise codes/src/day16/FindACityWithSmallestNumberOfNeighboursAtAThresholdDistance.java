package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindACityWithSmallestNumberOfNeighboursAtAThresholdDistance {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2;
        System.out.println(new FindACityWithSmallestNumberOfNeighboursAtAThresholdDistance().findTheCity(n,edges,distanceThreshold));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> list = new ArrayList<>(n);
        for(int i = 0 ; i < n ;i++ ){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int from = edge[0], to = edge[1], wt = edge[2];
            list.get(from).add(new int[]{to,wt});
            list.get(to).add(new int[]{from,wt});
        }

        int minCitiesVisited = n, city = n;
        for(int node = 0 ; node < n ;node++ ){
            int citiesVisited = dijkstras(list,node,distanceThreshold,n);
            if(citiesVisited <= minCitiesVisited){
                minCitiesVisited = citiesVisited;
                city = node;
            }
        }
        return city;

    }

    public int dijkstras(List<List<int[]>> adj, int start, int threshold, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start,0});

        int[] distance = new int[n];
        Arrays.fill(distance,(int)(1e9));
        distance[start] = 0;

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[0], wt = arr[1];
            for(int[] neighbours : adj.get(node)){
                int adjNode = neighbours[0], adjWt = neighbours[1];
                if(wt + adjWt <= threshold && wt + adjWt < distance[adjNode]){
                    distance[adjNode] = wt + adjWt;
                    pq.offer(new int[]{adjNode,distance[adjNode]});
                }
            }
        }

        int citiesVisited = 0;
        for(int d : distance){
            if(d != (int)(1e9))citiesVisited++;
        }
        return citiesVisited;
    }
}
