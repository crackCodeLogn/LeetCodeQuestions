package leetcode.contest.weekly.w445_202504;

/**
 * @author Vivek
 * @since 2025-04-12
 */
public class Q3517_M_SmallestPalindromicRearrangementI {

  public static void main(String[] args) {
    Q3517_M_SmallestPalindromicRearrangementI q3517MSamllestPalindromicRearrangementI =
        new Q3517_M_SmallestPalindromicRearrangementI();
    System.out.println(q3517MSamllestPalindromicRearrangementI.smallestPalindrome("z"));
    System.out.println(q3517MSamllestPalindromicRearrangementI.smallestPalindrome("babab"));
    System.out.println(q3517MSamllestPalindromicRearrangementI.smallestPalindrome("daccad"));
  }

  public String smallestPalindrome(String s) {
    if (s.length() == 1) return s;

    StringBuilder data = new StringBuilder();
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
    char oddChar = 'Z';
    for (int i = 0; i < 26; i++) {
      if (isOdd(count[i])) oddChar = (char) (i + 'a');
      count[i] /= 2;
      while (count[i]-- > 0) data.append((char) (i + 'a'));
    }
    if (oddChar != 'Z') data.append(oddChar);
    for (int i = isOdd(s.length()) ? data.length() - 2 : data.length() - 1; i >= 0; i--)
      data.append(data.charAt(i));
    return data.toString();
  }

  private boolean isOdd(int n) {
    return (n & 1) == 1;
  }
}
