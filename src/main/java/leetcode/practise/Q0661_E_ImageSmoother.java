package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-19
 */
public class Q0661_E_ImageSmoother {

    private static final int[] x = {0, -1, +1, -1, +1, -1, +1, +0, +0};
    private static final int[] y = {0, -1, +1, +0, +0, +1, -1, +1, -1};

    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double avg = 0;
                int v = 0;
                for (int k = 0; k < 10; k++) {
                    try {
                        avg += img[i + x[k]][j + y[k]];
                        v++;
                    } catch (Exception e) {
                    }
                }
                avg /= v;
                result[i][j] = (int) Math.floor(avg);
            }
        }
        return result;
    }
}
