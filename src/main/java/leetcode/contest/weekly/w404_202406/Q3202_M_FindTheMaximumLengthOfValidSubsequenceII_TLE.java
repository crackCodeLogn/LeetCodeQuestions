package leetcode.contest.weekly.w404_202406;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-06-30
 * TLE
 */
public class Q3202_M_FindTheMaximumLengthOfValidSubsequenceII_TLE {

    private int[][] dp;

    public static void main(String[] args) {
        Q3202_M_FindTheMaximumLengthOfValidSubsequenceII_TLE q3202MFindTheMaximumLengthOfValidSubsequenceIITLE = new Q3202_M_FindTheMaximumLengthOfValidSubsequenceII_TLE();
        System.out.println(q3202MFindTheMaximumLengthOfValidSubsequenceIITLE.maximumLength(new int[]{1, 2, 3, 4, 5}, 2)); // 5
        System.out.println(q3202MFindTheMaximumLengthOfValidSubsequenceIITLE.maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3)); // 4
    }

    public int maximumLength(int[] nums, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        dp = new int[nums.length][k + 1];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());

            for (int j = i + 1; j < n; j++) {
                map.get(i).add(new int[]{j, (nums[j] + nums[i]) % k});
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int[] arr : map.get(i)) {
                if (arr == null) continue;

                int target = arr[1];
                maxLen = Math.max(maxLen, traverse(arr[0], target, map));
            }
        }
        return maxLen + 1;
    }

    private int traverse(int key, int target, Map<Integer, List<int[]>> data) {
        List<int[]> list = data.get(key);
        if (list == null) return 0;
        if (dp[key][target] != 0) return dp[key][target];

        int v = 1;
        for (int[] arr : list) {
            if (arr[1] == target) {
                v = Math.max(v, 1 + traverse(arr[0], target, data));
            }
        }
        dp[key][target] = v;
        return v;
    }
}
