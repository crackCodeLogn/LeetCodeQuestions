package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-03
 */
public class Q2825_M_MakeStringASubsequenceUsingCyclicIncrements {

  public static void main(String[] args) {
    Q2825_M_MakeStringASubsequenceUsingCyclicIncrements
        q2825MMakeStringASubsequenceUsingCyclicIncrements =
            new Q2825_M_MakeStringASubsequenceUsingCyclicIncrements();
    System.out.println(
        q2825MMakeStringASubsequenceUsingCyclicIncrements.canMakeSubsequence("abc", "ad"));
    System.out.println(
        q2825MMakeStringASubsequenceUsingCyclicIncrements.canMakeSubsequence("zc", "ad"));
    System.out.println(
        q2825MMakeStringASubsequenceUsingCyclicIncrements.canMakeSubsequence("ab", "d"));
    System.out.println(
        q2825MMakeStringASubsequenceUsingCyclicIncrements.canMakeSubsequence("az", "d"));
  }

  public boolean canMakeSubsequence(String str1, String str2) { // 5ms, beats 100%
    if (str2.length() > str1.length()) return false;

    int k = 0;
    char ref = str2.charAt(k);
    for (int i = 0; i < str1.length(); i++) {
      char ch = str1.charAt(i);
      if (ch == ref || cycleChar(ch) == ref) {
        k++;
        if (k == str2.length()) return true;
        else ref = str2.charAt(k);
      }
    }
    return false;
  }

  private char cycleChar(char ch) {
    return ch == 'z' ? 'a' : ++ch;
  }
}
