package leetcode.contest.weekly.w411_202408;

/**
 * @author Vivek
 * @since 2024-08-18
 */
public class Q3258_E_CountSubstringsThatSatisfyKConstraintI {

    public static void main(String[] args) {
        Q3258_E_CountSubstringsThatSatisfyKConstraintI q3258ECountSubstringsThatSatisfyKConstraintI = new Q3258_E_CountSubstringsThatSatisfyKConstraintI();
        System.out.println(q3258ECountSubstringsThatSatisfyKConstraintI.countKConstraintSubstrings("10101", 1));
        System.out.println(q3258ECountSubstringsThatSatisfyKConstraintI.countKConstraintSubstrings("1010101", 2));
        System.out.println(q3258ECountSubstringsThatSatisfyKConstraintI.countKConstraintSubstrings("11111", 1));
    }

    public int countKConstraintSubstrings(String s, int m) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int c0 = 0, c1 = 0;
                for (int k = i; k <= j; k++) {
                    if (s.charAt(k) == '1') c1++;
                    else c0++;
                }
                if (c1 <= m || c0 <= m) cnt++;
            }
        }
        return cnt;
    }
}
