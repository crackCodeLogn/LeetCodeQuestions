package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-11-04
 */
public class Q2914_M_MinimumNumberOfChangesToMakeBinaryStringBeautiful {

  public static void main(String[] args) {
    Q2914_M_MinimumNumberOfChangesToMakeBinaryStringBeautiful
        q2914MMinimumNumberOfChangesToMakeBinaryStringBeautiful =
            new Q2914_M_MinimumNumberOfChangesToMakeBinaryStringBeautiful();
    System.out.println(q2914MMinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges("1001"));
    System.out.println(q2914MMinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges("10"));
    System.out.println(q2914MMinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges("0000"));
  }

  public int minChanges(String s) { // 3ms
    int cnt = 0;
    for (int i = 0; i < s.length(); i += 2) if (s.charAt(i) != s.charAt(i + 1)) cnt++;
    return cnt;
  }

  public int minChanges2(String s) { // 5ms
    int c1 = 0, c0 = 0, cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') c1++;
      else c0++;
      if (i % 2 == 1) {
        if (c1 == c0) cnt++;
        c0 = c1 = 0;
      }
    }
    return cnt;
  }
}
