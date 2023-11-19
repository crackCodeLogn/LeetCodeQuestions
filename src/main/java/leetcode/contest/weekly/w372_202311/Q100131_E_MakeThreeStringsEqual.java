package leetcode.contest.weekly.w372_202311;

/**
 * @author Vivek
 * @since 2023-11-19
 */
public class Q100131_E_MakeThreeStringsEqual {

    public static void main(String[] args) {
        Q100131_E_MakeThreeStringsEqual q = new Q100131_E_MakeThreeStringsEqual();
        System.out.println(q.findMinimumOperations("abc", "abb", "ab"));
        System.out.println(q.findMinimumOperations("dac", "abb", "fd"));
        System.out.println(q.findMinimumOperations("cc", "cccb", "c"));
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        String prefix = s1;
        if (s2.length() < prefix.length()) prefix = prefix.substring(0, s2.length());
        for (int i = 0; i <= prefix.length(); i++) {
            if (!prefix.substring(0, i).equals(s2.substring(0, i))) {
                prefix = prefix.substring(0, i - 1);
                break;
            }
        }
        if (s3.length() < prefix.length()) prefix = prefix.substring(0, s3.length());
        for (int i = 0; i <= prefix.length(); i++) {
            if (!prefix.substring(0, i).equals(s3.substring(0, i))) {
                prefix = prefix.substring(0, i - 1);
                break;
            }
        }
        return prefix.isEmpty() ? -1 : (s1.length() + s2.length() + s3.length() - 3 * prefix.length());
    }
}
