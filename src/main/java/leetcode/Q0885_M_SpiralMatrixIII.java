package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-08-08
 */
public class Q0885_M_SpiralMatrixIII {
    public static void main(String[] args) {
        Q0885_M_SpiralMatrixIII q0885MSpiralMatrixIII = new Q0885_M_SpiralMatrixIII();
        System.out.println(Arrays.deepToString(q0885MSpiralMatrixIII.spiralMatrixIII(1, 4, 0, 0)));
        System.out.println(Arrays.deepToString(q0885MSpiralMatrixIII.spiralMatrixIII(5, 6, 1, 4)));
    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{rStart, cStart});

        for (int i = 0; ans.size() < rows * cols; i++)
            for (int step = 0; step < i / 2 + 1; step++) {
                rStart += dy[i % 4];
                cStart += dx[i % 4];
                if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols)
                    ans.add(new int[]{rStart, cStart});
            }

        return ans.toArray(int[][]::new);
    }
}
