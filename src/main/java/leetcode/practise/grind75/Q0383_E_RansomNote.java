package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0383_E_RansomNote {
    public boolean canConstruct(String data, String magazine) {
        int[] cnt = new int[130];
        for (int i = 0; i < magazine.length(); i++) cnt[magazine.charAt(i)]++;
        for (int i = 0; i < data.length(); i++) {
            int ch = data.charAt(i);
            if (cnt[ch] <= 0) return false;
            cnt[ch]--;
        }
        return true;
    }
}
