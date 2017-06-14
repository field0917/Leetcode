// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
import java.util.Set;
import java.util.HashSet;

public class Solution {
  public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i < 9; i++) {
    	Set<Character> row = new HashSet<>();
    	Set<Character> column = new HashSet<>();
    	Set<Character> cube = new HashSet<>();

    	for(int j = 0; j < 9; j++) {
    		if(board[i][j] != '.' && !row.add(board[i][j])) 
    			return false;
    		if(board[j][i] != '.' && !column.add(board[j][i]))
    			return false;

    		int rowIndex = 3 * (i / 3);
    		int colIndex = 3 * (i % 3);
    		if(board[rowIndex + j/3][colIndex + j%3] != '.' && !cube.add(board[rowIndex + j/3][colIndex + j%3]))
    			return false;
    	}
    }
    return true;
  }
}


// 2nd time doing it mostly by my self except cube part
public class Solution {
  public boolean isValidSudoku(char[][] board) {

    for (int i = 0; i < board.length; i++) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> cube = new HashSet<>();

        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != '.') {
                if (row.contains(board[i][j])) return false;
                else row.add(board[i][j]);
            }

            if (board[j][i] != '.') {
                if (col.contains(board[j][i])) return false;
                else col.add(board[j][i]);
            }

            int rowIdx = (j / 3) + (i / 3) * 3;
            int colIdx = (j % 3) + (i % 3) * 3;
            if (board[rowIdx][colIdx] != '.' && !cube.add(board[rowIdx][colIdx])) return false;

        }
    }
    return true;
  }
}