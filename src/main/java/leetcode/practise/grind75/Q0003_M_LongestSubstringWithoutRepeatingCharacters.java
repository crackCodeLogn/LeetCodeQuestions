package leetcode.practise.grind75;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-01-28
 */
public class Q0003_M_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Q0003_M_LongestSubstringWithoutRepeatingCharacters q0003MLongestSubstringWithoutRepeatingCharacters = new Q0003_M_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(q0003MLongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(q0003MLongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(q0003MLongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(q0003MLongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(" ")); // 1
        System.out.println(q0003MLongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("")); // 0
        System.out.println(q0003MLongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("au")); // 2
    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int max = 0;
        int k = 0;
        if (s.length() <= 1) return s.length();

        Set<Character> data = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (data.contains(ch)) {
                max = Math.max(max, length);
                int j = k;
                for (; j < i && s.charAt(j) != ch; j++) {
                    data.remove(s.charAt(j));
                    length--;
                }
                k = j + 1;
            } else {
                data.add(ch);
                length++;
            }
        }
        max = Math.max(max, length);
        return max;
    }
}