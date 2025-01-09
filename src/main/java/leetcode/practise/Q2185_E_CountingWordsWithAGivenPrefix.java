package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-01-08
 */
public class Q2185_E_CountingWordsWithAGivenPrefix {

  public int prefixCount(String[] words, String pref) {
    int cnt = 0;
    for (String word : words) if (word.startsWith(pref)) cnt++;
    return cnt;
  }
}
