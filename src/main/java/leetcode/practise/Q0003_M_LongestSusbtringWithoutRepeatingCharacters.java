package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-10-26
 */
public class Q0003_M_LongestSusbtringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Q0003_M_LongestSusbtringWithoutRepeatingCharacters longestSusbtringWithoutRepeatingCharacters = new Q0003_M_LongestSusbtringWithoutRepeatingCharacters();
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbb"));
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("cbabzgpb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int[] counter = new int[130];
        int length = 0, maxLength = -1;
        Arrays.fill(counter, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (counter[ch] != -1) {
                int target = counter[ch];
                for (int j = 0; j < counter.length; j++) {
                    if (counter[j] != -1 && counter[j] <= target) {
                        counter[j] = -1;
                        length--;
                    }
                }
            }
            length++;
            maxLength = Math.max(maxLength, length);
            counter[ch] = i;
        }
        return maxLength;
    }
}
