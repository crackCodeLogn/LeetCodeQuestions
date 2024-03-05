package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-05
 */
public class Q1750_M_MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        Q1750_M_MinimumLengthOfStringAfterDeletingSimilarEnds q1750MMinimumLengthOfStringAfterDeletingSimilarEnds = new Q1750_M_MinimumLengthOfStringAfterDeletingSimilarEnds();
        System.out.println(q1750MMinimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("ca")); // 2
        System.out.println(q1750MMinimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("cabaabac")); // 0
        System.out.println(q1750MMinimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("aabccabba")); // 3
        System.out.println(q1750MMinimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("a")); // 1
        System.out.println(q1750MMinimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb")); // 1
        /*
        b
         */
    }

    public int minimumLength(String s) {
        int n = s.length(), left = 0, right = n - 1;
        if (n == 1) return 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                char ch = s.charAt(left);
                while (left < n && s.charAt(left) == ch) left++;
                if (left > right) break;
                while (right >= 0 && s.charAt(right) == ch) right--;
            } else break;
        }
        return right < left ? 0 : right - left + 1;
    }
}
