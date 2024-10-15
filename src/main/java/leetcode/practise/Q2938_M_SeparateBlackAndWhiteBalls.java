package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-10-14
 */
public class Q2938_M_SeparateBlackAndWhiteBalls {
  public static void main(String[] args) {
    Q2938_M_SeparateBlackAndWhiteBalls q2938MSeparateBlackAndWhiteBalls =
        new Q2938_M_SeparateBlackAndWhiteBalls();
    System.out.println(q2938MSeparateBlackAndWhiteBalls.minimumSteps("101"));
    System.out.println(q2938MSeparateBlackAndWhiteBalls.minimumSteps("100"));
    System.out.println(q2938MSeparateBlackAndWhiteBalls.minimumSteps("011"));
  }

  public long minimumSteps(String s) {
    long num = 0, cnt = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') cnt++;
      else num += cnt;
    }
    return num;
  }
}
