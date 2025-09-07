package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 9/6/25
 */
public class Q1304_E_FindNUniqueIntegersSumUpToZero {
  public static void main(String[] args) {
    Q1304_E_FindNUniqueIntegersSumUpToZero q1304EFindNUniqueIntegersSumUpToZero =
        new Q1304_E_FindNUniqueIntegersSumUpToZero();
    System.out.println(Arrays.toString(q1304EFindNUniqueIntegersSumUpToZero.sumZero(5)));
    System.out.println(Arrays.toString(q1304EFindNUniqueIntegersSumUpToZero.sumZero(3)));
    System.out.println(Arrays.toString(q1304EFindNUniqueIntegersSumUpToZero.sumZero(1)));
  }

  public int[] sumZero(int n) { // 0ms, beats 100%
    int[] data = new int[n];
    int i = 0;
    if ((n & 1) == 1) {
      data[0] = 0;
      i++;
    }
    for (int j = 1; i < n; j++) {
      data[i++] = -1 * j;
      data[i++] = j;
    }
    return data;
  }
}
