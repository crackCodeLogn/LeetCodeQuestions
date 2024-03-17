package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-03-17
 */
public class Q0057_M_InsertInterval {

    public static void main(String[] args) {
        Q0057_M_InsertInterval q0057MInsertInterval = new Q0057_M_InsertInterval();
        System.out.println(Arrays.deepToString(q0057MInsertInterval.insert(new int[][]{
                {2, 3},
                {5, 5},
                {6, 6},
                {7, 7},
                {8, 11},
        }, new int[]{6, 13})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> data = new ArrayList<>(intervals.length);
        Collections.addAll(data, intervals);

        List<Integer> impacted = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int[] interval = data.get(i);
            if (intersect(interval, newInterval)) impacted.add(i);
        }

        if (impacted.isEmpty()) { // no overlaps, find placement
            boolean flag = false;
            for (int i = 0; i < data.size(); i++) {
                if (newInterval[0] < data.get(i)[0]) {
                    data.add(i, newInterval);
                    flag = true;
                    break;
                }
            }
            if (!flag) data.add(newInterval);
        } else {
            int[] startExisting = data.get(impacted.get(0));
            int[] endExisting = data.get(impacted.get(impacted.size() - 1));
            int[] newOverall = compute(startExisting, endExisting, newInterval);
            for (int i = impacted.size() - 1; i >= 1; i--) data.remove((int) (impacted.get(i)));
            data.set(impacted.get(0), newOverall);
        }
        int[][] result = new int[data.size()][2];
        for (int i = 0; i < result.length; i++) result[i] = data.get(i);
        return result;
    }

    private int[] compute(int[] startExisting, int[] endExisting, int[] newInterval) {
        int[] data = new int[2];
        data[0] = Math.min(newInterval[0], startExisting[0]);
        data[1] = Math.max(newInterval[1], endExisting[1]);
        return data;
    }

    private boolean intersect(int[] first, int[] second) {
        if (second[0] >= first[0] && second[0] <= first[1]) return true;
        if (second[1] >= first[0] && second[1] <= first[1]) return true;
        if (second[0] <= first[0] && second[1] >= first[1]) return true;
        return first[0] <= second[0] && first[1] >= second[1];
    }
}
