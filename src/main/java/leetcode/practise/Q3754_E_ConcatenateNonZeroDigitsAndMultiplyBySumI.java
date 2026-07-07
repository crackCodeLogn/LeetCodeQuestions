package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-07-06
 */
public class Q3754_E_ConcatenateNonZeroDigitsAndMultiplyBySumI {
  public long sumAndMultiply(int n) { // 1ms, beats 99.85%
    long sum = 0, x = 0, mult = 1;
    while (n > 0) {
      int v = n % 10;
      n /= 10;
      if (v > 0) {
        x = mult * v + x;
        mult *= 10;
        sum += v;
      }
    }
    return x * sum;
  }

  public static void main(String[] args) {
    Q3754_E_ConcatenateNonZeroDigitsAndMultiplyBySumI
        q3754EConcatenateNonZeroDigitsAndMultiplyBySumI =
            new Q3754_E_ConcatenateNonZeroDigitsAndMultiplyBySumI();
    System.out.println(q3754EConcatenateNonZeroDigitsAndMultiplyBySumI.sumAndMultiply(10203004));
    System.out.println(q3754EConcatenateNonZeroDigitsAndMultiplyBySumI.sumAndMultiply(1000));
  }
}
