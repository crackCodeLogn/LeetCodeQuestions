package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0409_E_LongestPalindrome {

    public static void main(String[] args) {
        Q0409_E_LongestPalindrome q0409ELongestPalindrome = new Q0409_E_LongestPalindrome();
        System.out.println(q0409ELongestPalindrome.longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        int[] data = new int[130];
        for (int i = 0; i < s.length(); i++) data[s.charAt(i)]++;
        int cnt = 0;
        boolean flag = true;
        for (int i = 65; i < 130; i++) {
            int v = data[i];
            if (v == 0) continue;
            if (flag && (v & 1) == 1) {
                cnt++;
                v--;
                flag = false;
            }
            if ((v & 1) == 1) v--;
            cnt += v;
        }
        return cnt;
    }
}
