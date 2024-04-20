package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

public class Q1992_M_FindAllGroupsOfFarmland {

    public int[][] findFarmland(int[][] land) {
        List<int[]> data = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] x = {i, j, 0, 0};
                    int c = j, r = i + 1;
                    for (; c < land[0].length && land[i][c] == 1; c++) land[i][c] = -1;
                    c--;
                    outer:
                    for (; r < land.length; r++)
                        for (int y = j; y <= c; y++)
                            if (land[r][y] == 1) land[r][y] = -1;
                            else break outer;
                    r--;
                    x[2] = r;
                    x[3] = c;
                    data.add(x);
                }
            }
        }

        int[][] res = new int[data.size()][];
        for (int i = 0; i < data.size(); i++) res[i] = data.get(i);
        return res;
    }
}
