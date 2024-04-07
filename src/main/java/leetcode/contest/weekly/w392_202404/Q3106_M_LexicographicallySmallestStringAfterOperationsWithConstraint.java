package leetcode.contest.weekly.w392_202404;

/**
 * @author Vivek
 * @since 2024-04-07
 */
public class Q3106_M_LexicographicallySmallestStringAfterOperationsWithConstraint {

    public static void main(String[] args) {
        Q3106_M_LexicographicallySmallestStringAfterOperationsWithConstraint q3106MLexicographicallySmallestStringAfterOperationsWithConstraint = new Q3106_M_LexicographicallySmallestStringAfterOperationsWithConstraint();
        System.out.println(q3106MLexicographicallySmallestStringAfterOperationsWithConstraint.getSmallestString("zbbz", 3));
        System.out.println(q3106MLexicographicallySmallestStringAfterOperationsWithConstraint.getSmallestString("xaxcd", 4));
        System.out.println(q3106MLexicographicallySmallestStringAfterOperationsWithConstraint.getSmallestString("lol", 0));
    }

    public String getSmallestString(String s, int k) {
        if (k == 0) return s;

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (k == 0) {
                res = res.append(s.substring(i));
                break;
            }
            char ch = s.charAt(i);
            int c1 = ch - 'a', c2 = 'z' - ch + 1;
            int min = Math.min(c1, c2);
            if (k >= min) {
                k -= min;
                res.append('a');
            } else {
                res.append((char) (ch - k));
                k = 0;
            }
        }
        return res.toString();
    }
}
