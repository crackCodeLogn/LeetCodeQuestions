package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-25
 */
public class Q1143_M_LongestCommonSubsequence {

    public static void main(String[] args) {
        Q1143_M_LongestCommonSubsequence q1143MLongestCommonSubsequence = new Q1143_M_LongestCommonSubsequence();
        System.out.println(q1143MLongestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] data = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) data[i][j] = data[i - 1][j - 1] + 1;
                else data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);
            }
        }

        return data[n][m];
    }
}
