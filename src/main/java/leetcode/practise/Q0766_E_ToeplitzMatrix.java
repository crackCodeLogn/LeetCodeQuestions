package leetcode.practise;

/**
 * @author Vivek
 * @since 31/10/22
 */
public class Q0766_E_ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 || n == 1) return true;
        int iStart = m - 2, jStart = 1;
        while (iStart >= 0) {
            int last = matrix[iStart][0];
            for (int i = iStart + 1, j = 1; i < m && j < n; i++, j++)
                if (matrix[i][j] != last) return false;
            iStart--;
        }
        while (jStart < n - 1) {
            int last = matrix[0][jStart];
            for (int i = 1, j = jStart + 1; i < m && j < n; i++, j++)
                if (matrix[i][j] != last) return false;
            jStart++;
        }
        return true;
    }
}