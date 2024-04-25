package leetcode.contest.weekly.w394_202404;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-04-21
 */
public class Q3121_M_CountTheNumberOfSpecialCharactersII {

    public static void main(String[] args) {
        Q3121_M_CountTheNumberOfSpecialCharactersII q3121MCountTheNumberOfSpecialCharactersII = new Q3121_M_CountTheNumberOfSpecialCharactersII();
        System.out.println(q3121MCountTheNumberOfSpecialCharactersII.numberOfSpecialChars("aaAbcBC"));
        System.out.println(q3121MCountTheNumberOfSpecialCharactersII.numberOfSpecialChars("abc"));
        System.out.println(q3121MCountTheNumberOfSpecialCharactersII.numberOfSpecialChars("AbBCab"));
        System.out.println(q3121MCountTheNumberOfSpecialCharactersII.numberOfSpecialChars("cCceDC"));
    }

    public int numberOfSpecialChars(String word) {
        int cnt = 0;
        int[] up = new int[26];
        Arrays.fill(up, -1);

        Set<Character> upper = new HashSet<>();
        Map<Character, Integer> lower = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper.add(ch);
                if (up[ch - 'A'] == -1) up[ch - 'A'] = i;
            } else lower.put(ch, i);
        }
        for (char low : lower.keySet()) {
            char upp = Character.toUpperCase(low);
            if (upper.contains(upp) && lower.get(low) < up[upp - 'A']) cnt++;
        }
        return cnt;
    }
}
