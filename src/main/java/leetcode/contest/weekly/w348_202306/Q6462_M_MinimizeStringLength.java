package leetcode.contest.weekly.w348_202306;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-06-04
 */
public class Q6462_M_MinimizeStringLength {

    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
