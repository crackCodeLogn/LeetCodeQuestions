package leetcode.contest.weekly.w341_202304;

/**
 * @author Vivek
 * @since 2023-04-16
 */
public class Q6376_E_RowWithMaximumOnes {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];
        int num = 0;
        int v = 0;
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) cnt++;
            }
            if (cnt > num) {
                num = cnt;
                v = i;
            }
        }
        result[0] = v;
        result[1] = num;
        return result;
    }
}
