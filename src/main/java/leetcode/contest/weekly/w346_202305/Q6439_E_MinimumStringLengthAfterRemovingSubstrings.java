package leetcode.contest.weekly.w346_202305;

/**
 * @author Vivek
 * @since 2023-05-21
 */
public class Q6439_E_MinimumStringLengthAfterRemovingSubstrings {

    public int minLength(String s) {
        while (true) {
            boolean changed = false;
            int index = s.indexOf("AB");
            if (index != -1) {
                s = s.replaceAll("AB", "");
                changed = true;
            }
            index = s.indexOf("CD");
            if (index != -1) {
                s = s.replaceAll("CD", "");
                changed = true;
            }
            if (!changed) break;
        }
        return s.length();
    }
}
