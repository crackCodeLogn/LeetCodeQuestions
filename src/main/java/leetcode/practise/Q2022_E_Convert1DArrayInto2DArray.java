package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-08-31
 */
public class Q2022_E_Convert1DArrayInto2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int[][] data = new int[m][n];
        int k = 0, r = -1, c = 0;
        for (; k < original.length; k++) {
            if (c % n == 0) {
                r++;
                c = 0;
            }
            data[r][c++] = original[k];
        }
        return data;
    }

}
