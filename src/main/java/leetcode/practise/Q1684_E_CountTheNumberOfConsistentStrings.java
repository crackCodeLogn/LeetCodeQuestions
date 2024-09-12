package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-09-11
 */
public class Q1684_E_CountTheNumberOfConsistentStrings {
  public static void main(String[] args) {
    Q1684_E_CountTheNumberOfConsistentStrings q1684ECountTheNumberOfConsistentStrings =
        new Q1684_E_CountTheNumberOfConsistentStrings();
    System.out.println(
        q1684ECountTheNumberOfConsistentStrings.countConsistentStrings(
            "ab", new String[] {"ad", "bd", "aaab", "baa", "badab"}));
  }

  public int countConsistentStrings(String allowed, String[] words) {
    int[] cnt = new int[26];
    for (int i = 0; i < allowed.length(); i++) cnt[allowed.charAt(i) - 'a']++;
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      boolean flag = true;
      for (int j = 0; j < word.length(); j++)
        if (cnt[word.charAt(j) - 'a'] == 0) {
          flag = false;
          break;
        }
      if (flag) count++;
    }
    return count;
  }
}
