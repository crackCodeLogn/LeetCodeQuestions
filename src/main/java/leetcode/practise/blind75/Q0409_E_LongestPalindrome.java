package leetcode.practise.blind75;

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
        for (int i = 0; i < 130; i++) {
            int v = data[i];
            if (v == 0) continue;
            int div = v / 2;
            cnt += div * 2;
            v = v % 2;
            if (v == 1 && flag) {
                cnt++;
                flag = false;
            }
        }
        return cnt;
    }
}
