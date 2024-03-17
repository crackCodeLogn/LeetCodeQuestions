package leetcode.contest.weekly.w389_202403;

/**
 * @author Vivek
 * @since 2024-03-17
 */
public class Q3083_M_ExistenceOfASubstringInAStringAndItsReverse {

    public static void main(String[] args) {
        Q3083_M_ExistenceOfASubstringInAStringAndItsReverse q3083MExistenceOfASubstringInAStringAndItsReverse = new Q3083_M_ExistenceOfASubstringInAStringAndItsReverse();
        System.out.println(q3083MExistenceOfASubstringInAStringAndItsReverse.isSubstringPresent("leetcode"));
        System.out.println(q3083MExistenceOfASubstringInAStringAndItsReverse.isSubstringPresent("abcba"));
        System.out.println(q3083MExistenceOfASubstringInAStringAndItsReverse.isSubstringPresent("abcd"));
        System.out.println(q3083MExistenceOfASubstringInAStringAndItsReverse.isSubstringPresent("ausoee")); // true
    }

    public boolean isSubstringPresent(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= s.length() - 2; i++) {
            String data = s.substring(i, i + 2);
            if (s2.contains(data)) return true;
        }
        return false;
    }
}
