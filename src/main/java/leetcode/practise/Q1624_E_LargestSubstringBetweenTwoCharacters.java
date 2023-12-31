package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-31
 */
public class Q1624_E_LargestSubstringBetweenTwoCharacters {

    public static void main(String[] args) {
        Q1624_E_LargestSubstringBetweenTwoCharacters q1624ELargestSubstringBetweenTwoCharacters = new Q1624_E_LargestSubstringBetweenTwoCharacters();
        System.out.println(q1624ELargestSubstringBetweenTwoCharacters.maxLengthBetweenEqualCharacters("abca"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int i2 = s.lastIndexOf(s.charAt(i));
            if (i2 != -1 && i2 != i) max = Math.max(max, i2 - i - 1);
        }
        return max;
    }
}
