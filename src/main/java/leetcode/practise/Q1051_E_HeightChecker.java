package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-06-10
 */
public class Q1051_E_HeightChecker {

    public int heightChecker(int[] heights) {
        int cnt = 0, n = heights.length;
        int[] expected = Arrays.copyOf(heights, n);
        Arrays.sort(expected);
        for (int i = 0; i < n; i++) if (expected[i] != heights[i]) cnt++;
        return cnt;
    }

}
