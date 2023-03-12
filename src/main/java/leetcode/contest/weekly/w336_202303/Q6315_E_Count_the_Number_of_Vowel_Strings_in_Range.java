package leetcode.contest.weekly.w336_202303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-03-12
 */
public class Q6315_E_Count_the_Number_of_Vowel_Strings_in_Range {

    private static final Set<Character> set = new HashSet<>();

    public static void main(String[] args) {

    }

    public int vowelStrings(String[] words, int left, int right) {
        populate();
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) cnt++;
        }
        return cnt;
    }

    private void populate() {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }
}
