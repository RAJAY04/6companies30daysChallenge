package day8;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;

                for (int j = 0; j < 4; j++) {
                    int nextX = dx[j] + x;
                    int nextY = dy[j] + y;

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        visited[nextX][nextY] = 2;
                        q.add(new Pair(nextX, nextY));
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if (rotted) time++;
        }

        return fresh == 0 ? time : -1;
    }
}
