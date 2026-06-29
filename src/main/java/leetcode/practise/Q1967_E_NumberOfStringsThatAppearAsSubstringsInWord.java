package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-29
 */
public class Q1967_E_NumberOfStringsThatAppearAsSubstringsInWord { // 0ms, beats 100%
  public int numOfStrings(String[] patterns, String word) {
    int cnt = 0;
    for (String pattern : patterns) if (word.indexOf(pattern) >= 0) cnt++;
    return cnt;
  }

  public static void main(String[] args) {
    Q1967_E_NumberOfStringsThatAppearAsSubstringsInWord
        q1967ENumberOfStringsThatAppearAsSubstringsInWord =
            new Q1967_E_NumberOfStringsThatAppearAsSubstringsInWord();
    System.out.println(
        q1967ENumberOfStringsThatAppearAsSubstringsInWord.numOfStrings(
            new String[] {"a", "abc", "bc", "d"}, "abc"));
    System.out.println(
        q1967ENumberOfStringsThatAppearAsSubstringsInWord.numOfStrings(
            new String[] {"a", "b", "c"}, "aaaaabbbbb"));
    System.out.println(
        q1967ENumberOfStringsThatAppearAsSubstringsInWord.numOfStrings(
            new String[] {"a", "a", "a"}, "ab"));
  }
}
