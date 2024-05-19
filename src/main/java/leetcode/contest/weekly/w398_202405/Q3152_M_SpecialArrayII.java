package leetcode.contest.weekly.w398_202405;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2024-05-19
 */
public class Q3152_M_SpecialArrayII {

    public static void main(String[] args) {
        Q3152_M_SpecialArrayII q3152MSpecialArrayII = new Q3152_M_SpecialArrayII();
        System.out.println(Arrays.toString(q3152MSpecialArrayII.isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] result = new boolean[queries.length];
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i < n; i++) if (((nums[i] ^ nums[i - 1]) & 1) == 0) set.add(i);
//        System.out.println(set);

        for (int i = 0; i < queries.length; i++) {
            int lb = queries[i][0], ub = queries[i][1];
            if (lb == ub) result[i] = true;
            else {
                if (set.contains(ub)) result[i] = false;
                else {
                    Integer lower = set.lower(ub);
                    result[i] = lower == null || lower <= lb;
                }
            }
        }

        return result;
    }
}
