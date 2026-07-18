package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2026-07-17
 */
public class Q1979_E_FindGreatestCommonDivisorOfArray { // 3 ms, beats 21.34%
  public int findGCD(int[] nums) {
    return getGcd(Arrays.stream(nums).min().getAsInt(), Arrays.stream(nums).max().getAsInt());
  }

  private static int getGcd(int a, int b) {
    if (a == 0) return b;
    return getGcd(b % a, a);
  }

  public static void main(String[] args) {
    Q1979_E_FindGreatestCommonDivisorOfArray q1979EFindGreatestCommonDivisorOfArray =
        new Q1979_E_FindGreatestCommonDivisorOfArray();
    System.out.println(q1979EFindGreatestCommonDivisorOfArray.findGCD(new int[] {2, 5, 6, 9, 10}));
    System.out.println(q1979EFindGreatestCommonDivisorOfArray.findGCD(new int[] {7, 5, 6, 8, 3}));
    System.out.println(q1979EFindGreatestCommonDivisorOfArray.findGCD(new int[] {3, 3}));
  }
}
