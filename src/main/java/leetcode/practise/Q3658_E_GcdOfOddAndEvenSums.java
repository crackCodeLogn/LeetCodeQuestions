package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-07-14
 */
public class Q3658_E_GcdOfOddAndEvenSums {
  public int gcdOfOddEvenSums(int n) { // 2ms, beats 26.14%
    int odd = 0, even = 0;
    boolean flag = true;
    for (int i = 1; i <= n * 2; i++, flag = !flag) {
      if (flag) odd += i;
      else even += i;
    }
    return getGcd(odd, even);
  }

  private static int getGcd(int a, int b) {
    if (a == 0) return b;
    return getGcd(b % a, a);
  }

  public static void main(String[] args) {
    Q3658_E_GcdOfOddAndEvenSums q3658EGcdOfOddAndEvenSums = new Q3658_E_GcdOfOddAndEvenSums();
    System.out.println(q3658EGcdOfOddAndEvenSums.gcdOfOddEvenSums(4));
    System.out.println(q3658EGcdOfOddAndEvenSums.gcdOfOddEvenSums(5));
    System.out.println(q3658EGcdOfOddAndEvenSums.gcdOfOddEvenSums(1));
  }
}
