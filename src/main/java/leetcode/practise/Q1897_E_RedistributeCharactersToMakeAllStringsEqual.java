package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-30
 */
public class Q1897_E_RedistributeCharactersToMakeAllStringsEqual {

    public boolean makeEqual(String[] words) {
        int[] cnt = new int[130];
        int n = words.length;
        if (n == 1) return true;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                cnt[word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < cnt.length; i++) if (cnt[i] > 0 && cnt[i] % n != 0) return false;
        return true;
    }
}
