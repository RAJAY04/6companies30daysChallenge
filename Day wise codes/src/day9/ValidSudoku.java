package day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> cols = new ArrayList<>(9);
        List<Set<Character>> grids = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grids.add(new HashSet<>());
        }
        for(int r = 0 ; r < 9 ; r++){
            for(int c = 0 ; c < 9 ; c++){
                Set<Character> row = rows.get(r);
                Set<Character> col = cols.get(c);
                Set<Character> grid = grids.get(findGridIndex(r,c));
                char ch = board[r][c];
                if(!row.contains(ch) && !col.contains(ch) && !grid.contains(ch)){
                    row.add(ch);
                    col.add(ch);
                    grid.add(ch);
                }else if(ch != '.'){
                    return false;
                }
            }
        }
        return true;
    }
    public int findGridIndex(int row , int col){
        return (row / 3) * 3 + (col / 3);
    }
}
