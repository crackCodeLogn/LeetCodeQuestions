package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-01-08
 */
public class Q0446_H_ArithmeticSlides2Subsequences {

    private static final Map<Long, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Q0446_H_ArithmeticSlides2Subsequences q0446HArithmeticSlides2Subsequences = new Q0446_H_ArithmeticSlides2Subsequences();
        System.out.println(q0446HArithmeticSlides2Subsequences.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10})); // 7
        System.out.println(q0446HArithmeticSlides2Subsequences.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7})); // 16
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        int[][] data = new int[n][n];
        map.clear();

        for (int i = 0; i < n; ++i) {
            long v = nums[i];
            List<Integer> val = map.get(v);
            if (val == null) {
                val = new ArrayList<>();
                map.put(v, val);
            }
            val.add(i);
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                long target = nums[j] * 2L - nums[i];
                if (map.containsKey(target))
                    for (int k : map.get(target)) if (k < j) data[i][j] += data[j][k] + 1;
                cnt += data[i][j];
            }

        return cnt;
    }
}
