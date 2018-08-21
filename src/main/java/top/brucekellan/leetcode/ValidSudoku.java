package top.brucekellan.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Example 1:
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * @author brucekellan
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            //Vertical
            if (!isSubValid(board, i, i, 0, 8)) {
                return false;
            }
            //Horizontal
            if (!isSubValid(board, 0, 8, i, i)) {
                return false;
            }
            //Block
            if (!isSubValid(board, (i % 3) * 3, (i % 3) * 3 + 2, (i / 3) * 3, (i / 3) * 3 + 2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSubValid(char[][] board, int column_s, int column_e, int row_s, int row_e) {
        Set set = new HashSet();
        int i = column_s;

        while (i <= column_e) {
            int j = row_s;
            while (j <= row_e) {
                if (board[i][j] != '.') {
                    if (set.add(board[i][j]) == false) {
                        return false;
                    }
                }
                j++;
            }
            i++;
        }
        return true;
    }

}
