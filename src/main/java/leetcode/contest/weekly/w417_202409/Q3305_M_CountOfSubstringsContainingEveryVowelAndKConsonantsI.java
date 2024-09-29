package leetcode.contest.weekly.w417_202409;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-09-28
 */
public class Q3305_M_CountOfSubstringsContainingEveryVowelAndKConsonantsI {

  public static void main(String[] args) {
    Q3305_M_CountOfSubstringsContainingEveryVowelAndKConsonantsI
        q3305MCountOfSubstringsContainingEveryVowelAndKConsonantsI =
            new Q3305_M_CountOfSubstringsContainingEveryVowelAndKConsonantsI();
    System.out.println(
        q3305MCountOfSubstringsContainingEveryVowelAndKConsonantsI.countOfSubstrings("aeioqq", 1));
    System.out.println(
        q3305MCountOfSubstringsContainingEveryVowelAndKConsonantsI.countOfSubstrings("aeiou", 0));
    System.out.println(
        q3305MCountOfSubstringsContainingEveryVowelAndKConsonantsI.countOfSubstrings(
            "ieaouqqieaouqq", 1));
  }

  public int countOfSubstrings(String word, int k) {
    int cnt = 0;
    for (int i = 0; i < word.length(); i++) {
      for (int j = i + 4 + k; j < word.length(); j++) {
        int[] counter = new int[26];
        for (int v = i; v <= j; v++) counter[word.charAt(v) - 'a']++;
        int sum =
            Arrays.stream(counter).sum()
                - counter[0]
                - counter['e' - 'a']
                - counter['i' - 'a']
                - counter['o' - 'a']
                - counter['u' - 'a'];
        if (sum == k
            && counter[0] > 0
            && counter['e' - 'a'] > 0
            && counter['o' - 'a'] > 0
            && counter['u' - 'a'] > 0
            && counter['i' - 'a'] > 0) cnt++;
      }
    }
    return cnt;
  }
}
