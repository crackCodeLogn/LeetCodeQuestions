package leetcode.contest.weekly.w346_202305;

/**
 * @author Vivek
 * @since 2023-05-21
 */
public class Q6454_E_LexicographicallySmallestPalindrome {

    public String makeSmallestPalindrome(String s2) {
        StringBuilder s = new StringBuilder(s2);
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 == c2) continue;
            if (c1 < c2) s.setCharAt(j, c1);
            else s.setCharAt(i, c2);
        }
        return s.toString();
    }
}
