package leetcode.contest.weekly.w339_202304;

/**
 * @author Vivek
 * @since 2023-04-02
 */
public class Q6362_E_FindTheLongestBalancedSubstringOfABinaryString {

    public static void main(String[] args) {
        Q6362_E_FindTheLongestBalancedSubstringOfABinaryString q6362EFindTheLongestBalancedSubstringOfABinaryString = new Q6362_E_FindTheLongestBalancedSubstringOfABinaryString();
        System.out.println(q6362EFindTheLongestBalancedSubstringOfABinaryString.findTheLongestBalancedSubstring("01000111"));
        System.out.println(q6362EFindTheLongestBalancedSubstringOfABinaryString.findTheLongestBalancedSubstring("00111"));
        System.out.println(q6362EFindTheLongestBalancedSubstringOfABinaryString.findTheLongestBalancedSubstring("111"));
        System.out.println(q6362EFindTheLongestBalancedSubstringOfABinaryString.findTheLongestBalancedSubstring("10011"));
        System.out.println(q6362EFindTheLongestBalancedSubstringOfABinaryString.findTheLongestBalancedSubstring("11110"));
    }

    public int findTheLongestBalancedSubstring(String s) {
        int c0 = 0, c1 = 0, n = s.length();
        if (n == 1) return 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') c1++;
            else c0++;
        }
        if (c0 == 0 || c1 == 0) return 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            c1 = 0;
            while (i < n && s.charAt(i) == '1') i++;
            if (i >= n) break;
            c0 = 1;
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '0' && !flag) c0++;
                else if (s.charAt(j) == '0' && flag) {
                    i = j - 1;
                    break;
                } else {
                    flag = true;
                    c1++;
                    max = Math.max(max, 2 * Math.min(c0, c1));
                }
            }
        }
        return max;
    }
}
