package leetcode.practise;

import java.util.Arrays;

public class Q1582_E_SpecialPositionsInBinaryMatrix {

    public int numSpecial(int[][] mat) {
        int cnt = 0, n = mat.length, m = mat[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        Arrays.fill(rows, true);
        Arrays.fill(cols, true);
        for (int i = 0; i < n; i++) {
            int local = 0;
            for (int j = 0; j < m; j++) if (mat[i][j] == 1) local++;
            if (local != 1) rows[i] = false;
        }
        for (int j = 0; j < m; j++) {
            int local = 0;
            for (int i = 0; i < n; i++) if (mat[i][j] == 1) local++;
            if (local != 1) cols[j] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) if (mat[i][j] == 1 && rows[i] && cols[j]) cnt++;
        }
        return cnt;
    }
}
