package leetcode.contest.weekly.w385_202402;

/**
 * @author Vivek
 * @since 2024-02-18
 */
public class Q100212_E_CountPrefixAndSuffixPairsI {

    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) cnt++;
            }
        }
        return cnt;
    }
}
