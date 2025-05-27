package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-05-26
 */
public class Q2894_E_DivisibleAndNonDivisibleSumsDifference {

  public int differenceOfSums(int n, int m) { // 1ms, beats 74.69%
    int data = 0;
    for (int i = 1; i <= n; i++) {
      if (i % m == 0) data -= i;
      else data += i;
    }
    return data;
  }
}
