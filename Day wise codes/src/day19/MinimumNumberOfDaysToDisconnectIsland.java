package day19;

public class MinimumNumberOfDaysToDisconnectIsland {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 0, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        System.out.println(minDays(grid));
    }

    public static int minDays(int[][] grid) {
        int islands = countIslands(grid);
        if (islands != 1) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    islands = countIslands(grid);
                    grid[i][j] = 1;
                    if (islands != 1) return 1;
                }
            }
        }

        return 2;
    }

    public static int countIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void dfs(int[][] grid, int r, int c, boolean[][] vis) {
        vis[r][c] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int row = r + dx[i];
            int col = c + dy[i];
            if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && !vis[row][col] && grid[row][col] == 1) {
                dfs(grid, row, col, vis);
            }
        }
    }
}
