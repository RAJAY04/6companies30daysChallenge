package day26;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHeightPeak {
    public static void main(String[] args) {
        MapOfHeightPeak obj = new MapOfHeightPeak();
        int[][] isWater = {{0,1},{0,0}};
        int[][] res = obj.highestPeak(isWater);
        for(int[] r : res){
            for(int i : r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    static class Pair{
        int height;
        int x;
        int y;
        Pair(int height,int x,int y){
            this.height = height;
            this.x = x;
            this.y = y;        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] res = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isWater[i][j] == 1){
                    q.add(new Pair(0,i,j));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.remove();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]){
                    res[nx][ny] = p.height + 1;
                    q.add(new Pair(p.height + 1,nx,ny));
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
