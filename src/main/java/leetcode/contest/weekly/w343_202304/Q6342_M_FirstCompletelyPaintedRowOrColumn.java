package leetcode.contest.weekly.w343_202304;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-04-30
 */
public class Q6342_M_FirstCompletelyPaintedRowOrColumn {
    private final Map<Integer, String> arrMatMap = new HashMap<>();

    public static void main(String[] args) {
        Q6342_M_FirstCompletelyPaintedRowOrColumn q6342MFirstCompletelyPaintedRowOrColumn = new Q6342_M_FirstCompletelyPaintedRowOrColumn();
        System.out.println(q6342MFirstCompletelyPaintedRowOrColumn.firstCompleteIndex(
                new int[]{1, 3, 4, 2},
                new int[][]{{1, 4}, {2, 3}}));
    }

    private String getStringLocation(int i, int j) {
        return i + "-" + j;
    }

    private int[] getLocation(String location) {
        int[] loc = new int[2];
        String[] loci = location.split("-");
        loc[0] = Integer.parseInt(loci[0]);
        loc[1] = Integer.parseInt(loci[1]);
        return loc;
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        List<Set<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < mat.length; i++)
            rows.add(new HashSet<>());
        List<Set<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < mat[0].length; i++)
            columns.add(new HashSet<>());

        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            Set<Integer> row = rows.get(i);
            for (int j = 0; j < mat[i].length; j++) {
                arrMatMap.put(mat[i][j], getStringLocation(i, j));

                Set<Integer> col = columns.get(j);
                row.add(mat[i][j]);
                col.add(mat[i][j]);
                k++;
            }
        }

        k = 0;
        for (; k < arr.length; k++) {
            String location = arrMatMap.get(arr[k]);
            int[] loc = getLocation(location);
            rows.get(loc[0]).remove(arr[k]);
            if (rows.get(loc[0]).isEmpty()) {
                break;
            }
            columns.get(loc[1]).remove(arr[k]);
            if (columns.get(loc[1]).isEmpty()) {
                break;
            }
        }
        return k;
    }
}
