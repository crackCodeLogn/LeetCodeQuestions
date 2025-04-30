package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-04-29
 */
public class Q1295_E_FindNumbersWithEvenNumberOfDigits {
  public static void main(String[] args) {
    Q1295_E_FindNumbersWithEvenNumberOfDigits q1295EFindNumbersWithEvenNumberOfDigits =
        new Q1295_E_FindNumbersWithEvenNumberOfDigits();
    System.out.println(
        q1295EFindNumbersWithEvenNumberOfDigits.findNumbers(new int[] {12, 345, 2, 6, 7896}));
    System.out.println(
        q1295EFindNumbersWithEvenNumberOfDigits.findNumbers(new int[] {555, 901, 482, 1771}));
  }

  public int findNumbers(int[] nums) { // 2ms, beats 26.47%
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = String.valueOf(nums[i]).length();
      cnt += ((count & 1) == 0) ? 1 : 0;
    }
    return cnt;
  }

  public int findNumbers3(int[] nums) { // 1ms, beats 98.76%
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      while (nums[i] > 0) {
        nums[i] /= 10;
        count++;
      }
      cnt += ((count & 1) == 0) ? 1 : 0;
    }
    return cnt;
  }

  public int findNumbers2(int[] nums) { // 2ms, beats 26.47%
    return Math.toIntExact(
        Arrays.stream(nums)
            .filter(
                v -> {
                  int v2 = v, count = 0;
                  while (v2 > 0) {
                    v2 /= 10;
                    count++;
                  }
                  return (count & 1) == 0;
                })
            .count());
  }
}
