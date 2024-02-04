package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-04
 */
public class Q0076_H_MinimumWindowSubstring {

    public static void main(String[] args) {
        Q0076_H_MinimumWindowSubstring q0076HMinimumWindowSubstring = new Q0076_H_MinimumWindowSubstring();
        System.out.println(q0076HMinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC")); //BANC
        System.out.println(q0076HMinimumWindowSubstring.minWindow("a", "a")); //a
        System.out.println(q0076HMinimumWindowSubstring.minWindow("a", "aa")); //
    }

    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int required = t.length();
        int bestLeft = -1;
        int minLength = s.length() + 1;

        for (int i = 0; i < t.length(); i++) count[t.charAt(i)]++;

        for (int l = 0, r = 0; r < s.length(); r++) {
            if (--count[s.charAt(r)] >= 0)
                required--;
            while (required == 0) {
                if (r - l + 1 < minLength) {
                    bestLeft = l;
                    minLength = r - l + 1;
                }
                if (++count[s.charAt(l++)] > 0)
                    required++;
            }
        }

        return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
    }
}
