package leetcode.contest.weekly.w390_202403;

/**
 * @author Vivek
 * @since 2024-03-24
 */
public class Q3090_E_MaximumLengthSubstringWithTwoOccurrences {

    public static void main(String[] args) {
        Q3090_E_MaximumLengthSubstringWithTwoOccurrences q3090EMaximumLengthSubstringWithTwoOccurrences = new Q3090_E_MaximumLengthSubstringWithTwoOccurrences();
        System.out.println(q3090EMaximumLengthSubstringWithTwoOccurrences.maximumLengthSubstring("bcbbbcba")); //4
        System.out.println(q3090EMaximumLengthSubstringWithTwoOccurrences.maximumLengthSubstring("aaaa")); //2
    }

    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int len = 1;
            cnt[s.charAt(i) - 'a']++;
            for (int j = i + 1; j < n; j++) {
                if (cnt[s.charAt(j) - 'a'] == 2) {
                    break;
                }
                len++;
                maxLen = Math.max(maxLen, len);
                cnt[s.charAt(j) - 'a']++;
            }
        }
        return maxLen;
    }
}
