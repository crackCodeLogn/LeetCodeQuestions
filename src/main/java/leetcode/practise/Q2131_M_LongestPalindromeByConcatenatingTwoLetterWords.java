package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-05-24
 */
public class Q2131_M_LongestPalindromeByConcatenatingTwoLetterWords {

  public static void main(String[] args) {
    Q2131_M_LongestPalindromeByConcatenatingTwoLetterWords
        q2131MLongestPalindromeByConcatenatingTwoLetterWords =
            new Q2131_M_LongestPalindromeByConcatenatingTwoLetterWords();

    System.out.println(
        q2131MLongestPalindromeByConcatenatingTwoLetterWords.longestPalindrome(
            new String[] {
              "dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"
            })); // 22
    System.out.println(
        q2131MLongestPalindromeByConcatenatingTwoLetterWords.longestPalindrome(
            new String[] {"ab", "ty", "yt", "lc", "cl", "ab"})); // 8
    System.out.println(
        q2131MLongestPalindromeByConcatenatingTwoLetterWords.longestPalindrome(
            new String[] {"lc", "cl", "gg", "lc", "cl"})); // 10
    System.out.println(
        q2131MLongestPalindromeByConcatenatingTwoLetterWords.longestPalindrome(
            new String[] {"lc", "cl", "gg", "lc"})); // 6
    System.out.println(
        q2131MLongestPalindromeByConcatenatingTwoLetterWords.longestPalindrome(
            new String[] {"lc", "cl", "gg"})); // 6
    System.out.println(
        q2131MLongestPalindromeByConcatenatingTwoLetterWords.longestPalindrome(
            new String[] {
              "cc", "ll", "xx",
            })); // 2
  }

  public int longestPalindrome(String[] words) { // 52ms, beats 84.96%
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) map.compute(word, (k, v) -> v == null ? 1 : v + 1);

    int len = 0;
    boolean oddBreak = false;
    for (String word : map.keySet()) {
      String revWord = getRev(word);
      if (!revWord.equals(word)
          && map.containsKey(revWord)
          && map.get(revWord) > 0
          && map.get(word) > 0) {
        int m = Math.min(map.get(revWord), map.get(word));
        len += m * 4;
        map.put(word, map.get(word) - m);
        map.put(revWord, map.get(revWord) - m);
      } else if (revWord.equals(word)) {
        int count = map.get(word);
        if (isEven(count)) {
          len += count * 2;
          map.put(word, 0);
        } else {
          if (!oddBreak) {
            oddBreak = true;
            len += 2;
          }
          count--;
          if (count > 0) len += count * 2;
        }
      }
    }
    return len;
  }

  private boolean isEven(int n) {
    return ((n & 1) == 0);
  }

  private String getRev(String word) {
    return word.charAt(1) + "" + word.charAt(0);
  }
}
