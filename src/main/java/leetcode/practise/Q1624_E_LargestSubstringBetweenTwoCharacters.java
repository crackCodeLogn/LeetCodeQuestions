package leetcode.practise;

import java.util.Arrays;

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
        int[][] location = new int[130][2];
        for (int i = 0; i < location.length; i++) Arrays.fill(location[i], -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (location[ch][0] == -1) location[ch][0] = i;
            else {
                location[ch][1] = i;
                max = Math.max(max, location[ch][1] - location[ch][0] - 1);
            }
        }
        return max;
    }

    public int maxLengthBetweenEqualCharacters2(String s) {
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int i2 = s.lastIndexOf(s.charAt(i));
            if (i2 != -1 && i2 != i) max = Math.max(max, i2 - i - 1);
        }
        return max;
    }
}
