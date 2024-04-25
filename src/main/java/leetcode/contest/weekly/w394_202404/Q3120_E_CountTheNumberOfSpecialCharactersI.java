package leetcode.contest.weekly.w394_202404;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-04-21
 */
public class Q3120_E_CountTheNumberOfSpecialCharactersI {

    public int numberOfSpecialChars(String word) {
        int cnt = 0;
        Set<Character> upper = new HashSet<>();
        Set<Character> lower = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) upper.add(ch);
            else lower.add(ch);
        }
        for (Character low : lower) if (upper.contains(Character.toUpperCase(low))) cnt++;
        return cnt;
    }
}
