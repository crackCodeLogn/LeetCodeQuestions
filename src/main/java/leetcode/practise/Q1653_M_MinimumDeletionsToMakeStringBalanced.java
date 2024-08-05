package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q1653_M_MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        int dp = 0;
        int countB = 0;
        for (final char c : s.toCharArray()) {
            if (c == 'a') dp = Math.min(dp + 1, countB);
            else countB++;
        }
        return dp;
    }
}
