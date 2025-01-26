package leetcode.contest.weekly.w434_202501;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-01-25
 */
public class Q3432_E_CountPartitionsWithEvenSumDifference {

  public static void main(String[] args) {
    Q3432_E_CountPartitionsWithEvenSumDifference q3432ECountPartitionsWithEvenSumDifference =
        new Q3432_E_CountPartitionsWithEvenSumDifference();
    System.out.println(
        q3432ECountPartitionsWithEvenSumDifference.countPartitions(new int[] {10, 10, 3, 7, 6}));
    System.out.println(
        q3432ECountPartitionsWithEvenSumDifference.countPartitions(new int[] {1, 2, 2}));
    System.out.println(
        q3432ECountPartitionsWithEvenSumDifference.countPartitions(new int[] {2, 4, 6, 8}));
  }

  public int countPartitions(int[] nums) {
    int count = 0;
    int sum = Arrays.stream(nums).sum(), run = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      run += nums[i];
      sum -= nums[i];
      if ((run - sum) % 2 == 0) count++;
    }
    return count;
  }
}
