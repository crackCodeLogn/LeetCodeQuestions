package leetcode.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-10-26
 */
public class Q0003_M_LongestSusbtringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Q0003_M_LongestSusbtringWithoutRepeatingCharacters longestSusbtringWithoutRepeatingCharacters = new Q0003_M_LongestSusbtringWithoutRepeatingCharacters();
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbb")); // 1
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("cbabzgpb")); // 5
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcde")); // 5
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("abba")); // 2
        System.out.println(longestSusbtringWithoutRepeatingCharacters.lengthOfLongestSubstring("tmmzuxt")); // 5
    }

    public int lengthOfLongestSubstring(String s) { // 6ms
        if (s.isEmpty()) return 0;

        Map<Character, Integer> data = new HashMap<>();
        int len = 1, prev = 0;
        int i;

        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!data.containsKey(ch) || prev > data.get(ch)) data.put(ch, i);
            else {
                len = Math.max(len, i - prev);
                prev = Math.max(prev, data.get(ch)) + 1;
                data.put(ch, i);
            }
        }
        len = Math.max(len, i - prev);
        return len;
    }

    public int lengthOfLongestSubstring2(String s) { // 4ms
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
