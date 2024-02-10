package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-11
 */
public class Q0647_M_PalindromicSubstrings {
    public static void main(String[] args) {
        Q0647_M_PalindromicSubstrings q0647MPalindromicSubstrings = new Q0647_M_PalindromicSubstrings();
        System.out.println(q0647MPalindromicSubstrings.countSubstrings("abc")); // 3
        System.out.println(q0647MPalindromicSubstrings.countSubstrings("aaa")); // 6
    }

    public int countSubstrings(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            cnt += compute(s, i, i);
            cnt += compute(s, i, i + 1);
        }

        return cnt;
    }

    private int compute(final String s, int l, int r) {
        int cnt = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }

        return cnt;
    }
}
