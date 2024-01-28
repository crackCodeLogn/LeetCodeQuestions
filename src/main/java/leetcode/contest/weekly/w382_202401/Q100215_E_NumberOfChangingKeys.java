package leetcode.contest.weekly.w382_202401;

/**
 * @author Vivek
 * @since 2024-01-28
 */
public class Q100215_E_NumberOfChangingKeys {

    public int countKeyChanges(String s) {
        int cnt = 0;
        s = s.toLowerCase();
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                ch = s.charAt(i);
                cnt++;
            }
        }
        return cnt;
    }
}
