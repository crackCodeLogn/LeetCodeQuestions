package leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Vivek
 * @since 30/10/22
 */
public class Q36_M_Valid_Sudoku {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Q36_M_Valid_Sudoku obj = new Q36_M_Valid_Sudoku();
        System.out.println(obj.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> columns = new ArrayList<>(9);
        List<Set<Character>> rows = new ArrayList<>(9);
        List<List<Set<Character>>> boxes = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) columns.add(new HashSet<>());
        for (int i = 0; i < 9; i++) rows.add(new HashSet<>());
        for (int i = 0; i < 3; i++) {
            boxes.add(new LinkedList<>());
            for (int j = 0; j < 3; j++) {
                boxes.get(i).add(new HashSet<>());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (columns.get(j).contains(board[i][j])) return false;
                columns.get(j).add(board[i][j]);
                if (rows.get(i).contains(board[i][j])) return false;
                rows.get(i).add(board[i][j]);
                int iB = i / 3, jB = j / 3;
                if (boxes.get(iB).get(jB).contains(board[i][j])) return false;
                boxes.get(iB).get(jB).add(board[i][j]);
            }
        }
        return true;
    }
}
