package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2026-01-03
 */
public class Q1390_M_FourDivisors {
  private static final Map<Integer, Integer> memo = new HashMap<>();

  public static void main(String[] args) {
    Q1390_M_FourDivisors q1390MFourDivisors = new Q1390_M_FourDivisors();
    System.out.println(q1390MFourDivisors.sumFourDivisors(new int[] {21, 4, 7})); // 32
    System.out.println(q1390MFourDivisors.sumFourDivisors(new int[] {21, 21})); // 64
    System.out.println(q1390MFourDivisors.sumFourDivisors(new int[] {1, 2, 3, 4, 5})); // 0
  }

  public int sumFourDivisors(int[] nums) {
    int sum = 0;
    for (int v : nums) {
      if (memo.containsKey(v)) sum += memo.get(v);
      else {
        int c = calc(v);
        if (c > 0) {
          memo.put(v, c);
          sum += c;
        }
      }
    }
    return sum;
  }

  private int calc(int v) {
    int cnt = 1 + v, c = 0;
    for (int i = 2; i <= v / i; i++) {
      if (v % i == 0) {
        cnt += i;
        c++;
        if (i * i != v) {
          c++;
          cnt += v / i;
        }
      }
      if (c > 2) return 0;
    }
    return c == 2 ? cnt : 0;
  }
}
