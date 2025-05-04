package leetcode.contest.weekly.w448_202505;

/**
 * @author Vivek
 * @since 2025-05-03
 */
public class Q3536_E_MaximumProductOfTwoDigits {

  public static void main(String[] args) {
    Q3536_E_MaximumProductOfTwoDigits q3536EMaximumProductOfTwoDigits =
        new Q3536_E_MaximumProductOfTwoDigits();
    System.out.println(q3536EMaximumProductOfTwoDigits.maxProduct(668));
    System.out.println(q3536EMaximumProductOfTwoDigits.maxProduct(31));
    System.out.println(q3536EMaximumProductOfTwoDigits.maxProduct(22));
    System.out.println(q3536EMaximumProductOfTwoDigits.maxProduct(124));
    System.out.println(q3536EMaximumProductOfTwoDigits.maxProduct(10));
    System.out.println(q3536EMaximumProductOfTwoDigits.maxProduct(22));
  }

  public int maxProduct(int n) {
    int data = 1;
    long[] flags = new long[10];
    String v = String.valueOf(n);
    for (int i = 0; i < v.length(); i++) flags[v.charAt(i) - '0']++;
    int a = 2;
    for (int i = flags.length - 1; i >= 0 && a != 0; i--) {
      if (flags[i] > 0) {
        a--;
        data *= i;
        flags[i]--;
        if (flags[i] > 0 && a > 0) {
          data *= i;
          break;
        }
      }
    }
    return data;
  }
}
