package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-05
 */
public class Q0387_E_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] cnt = new int[130];
        int n = s.length();
        for (int i = 0; i < n; i++) cnt[s.charAt(i)]++;

        for (int i = 0; i < n; i++) if (cnt[s.charAt(i)] == 1) return i;
        return -1;
    }
}
