package leetcode.contest.weekly.w409_202408;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q3243_M_ShortestDistanceAfterRoadAdditionQueriesI {

    Map<Integer, List<Integer>> data = new HashMap<>();
    int n;
    Map<Integer, Integer> dp = new HashMap<>();

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int k = 0;
        this.n = n;
        data.clear();
        for (int i = 0; i < n; i++) {
            data.put(i, new ArrayList<>());
            data.get(i).add(i + 1);
        }
        data.get(n - 1).clear();

        for (int i = 0; i < queries.length; i++) {
            dp.clear();
            int src = queries[i][0], dest = queries[i][1];
            data.get(src).add(dest);
            //System.out.println(data);
            res[k++] = compute(0) + 1;
        }

        return res;
    }

    private int compute(int current) {
        if (current == n) return 0;
        if (dp.containsKey(current)) return dp.get(current);

        int min = -1;
        for (int dest : data.get(current)) {
            int v = compute(dest) + 1;
            if (min == -1) min = v;
            else min = Math.min(min, v);
        }
        dp.put(current, min);
        return min;
    }
}
