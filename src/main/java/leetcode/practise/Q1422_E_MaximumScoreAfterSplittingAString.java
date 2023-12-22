package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-22
 */
public class Q1422_E_MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        if (s.length() == 2) {
            if (s.equals("00") || s.equals("11")) return 1;
            if (s.equals("01")) return 2;
            return 0; //"10"
        }
        int n = s.length();
        int[] c0 = new int[n];
        int[] c1 = new int[n];
        c0[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n - 1; i++) {
            int add = 0;
            if (s.charAt(i) == '0') add = 1;
            c0[i] = c0[i - 1] + add;
        }
        c1[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i > 0; i--) {
            int add = 0;
            if (s.charAt(i) == '1') add = 1;
            c1[i] = c1[i + 1] + add;
        }
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, c0[i] + c1[i]);
        }
        return max;
    }
}
