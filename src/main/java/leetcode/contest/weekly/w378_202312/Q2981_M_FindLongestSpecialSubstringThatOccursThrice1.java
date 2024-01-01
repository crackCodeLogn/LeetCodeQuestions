package leetcode.contest.weekly.w378_202312;

/**
 * @author Vivek
 * @since 2023-12-31
 */
public class Q2981_M_FindLongestSpecialSubstringThatOccursThrice1 {

    public static void main(String[] args) {
        Q2981_M_FindLongestSpecialSubstringThatOccursThrice1 q2981MFindLongestSpecialSubstringThatOccursThrice1 = new Q2981_M_FindLongestSpecialSubstringThatOccursThrice1();
        System.out.println(q2981MFindLongestSpecialSubstringThatOccursThrice1.maximumLength("aaaa"));
        System.out.println(q2981MFindLongestSpecialSubstringThatOccursThrice1.maximumLength("abcdef"));
        System.out.println(q2981MFindLongestSpecialSubstringThatOccursThrice1.maximumLength("abcaba"));
        System.out.println(q2981MFindLongestSpecialSubstringThatOccursThrice1.maximumLength("aaauuuxxxx")); // 2
        System.out.println(q2981MFindLongestSpecialSubstringThatOccursThrice1.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde")); // 2
    }

    public int maximumLength(String s) {
        int n = s.length();
        int v = -1;
        for (int i = 0; i < n - 2; i++) {
            int upper = 1;
            for (; i + upper < n && s.charAt(i + upper) == s.charAt(i); upper++) ;

            for (int j = upper; j >= 1; j--) {
                if (j + i > n) continue;
                String d = s.substring(i, i + j);
                int idx1 = s.indexOf(d, i + 1);
                if (idx1 != -1 && idx1 + j <= n) {
                    idx1 = s.indexOf(d, idx1 + 1);
                    if (idx1 != -1) {
                        v = Math.max(v, j);
                        //System.out.println("j: " + j + ", i: " + i + ", v: " + v);
                        break;
                    }
                }
            }
        }
        return v;
    }
}
