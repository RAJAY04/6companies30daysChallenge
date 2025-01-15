package day14;

public class BattleshipsInABoard {
    public static void main(String[] args) {
        char[][] board = {
            {'X','.','.','X'},
            {'.','.','.','X'},
            {'.','.','.','X'}
        };
        System.out.println(new BattleshipsInABoard().countBattleships(board));
    }

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ;j++){
                if(board[i][j] == 'X' && !vis[i][j]){
                    dfs(board,i,j,vis);
                    count++;
                }
            }
        }
        return count;

    }

    public void dfs(char[][] board,int r, int c, boolean[][] vis){
        if(r >= board.length || c >= board[0].length || r < 0 || c < 0 || vis[r][c] || board[r][c] == '.'){
            return;
        }

        vis[r][c] = true;
        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i];
            int col = c + dy[i];
            dfs(board,row,col,vis);
        }

    }

}
