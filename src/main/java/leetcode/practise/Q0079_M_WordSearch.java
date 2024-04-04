package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-04-03
 */
public class Q0079_M_WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) if (compute(board, word, i, j, 0)) return true;
        return false;
    }

    private boolean compute(char[][] board, String word, int i, int j, int s) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) return false;
        if (board[i][j] != word.charAt(s) || board[i][j] == '*') return false;
        if (s == word.length() - 1) return true;

        char cache = board[i][j];
        board[i][j] = '*';
        boolean isExist = compute(board, word, i + 1, j, s + 1) ||
                compute(board, word, i - 1, j, s + 1) ||
                compute(board, word, i, j + 1, s + 1) ||
                compute(board, word, i, j - 1, s + 1);
        board[i][j] = cache;
        return isExist;
    }
}
