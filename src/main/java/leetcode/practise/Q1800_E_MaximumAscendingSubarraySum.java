package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-02-03
 */
public class Q1800_E_MaximumAscendingSubarraySum {

  public static void main(String[] args) {
    Q1800_E_MaximumAscendingSubarraySum q1800EMaximumAscendingSubarraySum =
        new Q1800_E_MaximumAscendingSubarraySum();
    System.out.println(
        q1800EMaximumAscendingSubarraySum.maxAscendingSum(new int[] {10, 20, 30, 5, 10, 50}));
    System.out.println(
        q1800EMaximumAscendingSubarraySum.maxAscendingSum(new int[] {10, 20, 30, 40, 50}));
    System.out.println(
        q1800EMaximumAscendingSubarraySum.maxAscendingSum(new int[] {12, 17, 15, 13, 10, 11, 12}));
  }

  public int maxAscendingSum(int[] nums) { // 0ms, beats 100%
    int maxSum = nums[0], current = nums[0], lastVal = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= lastVal) {
        if (current > maxSum) maxSum = current;
        current = 0;
      }
      current += nums[i];
      lastVal = nums[i];
    }
    return Math.max(maxSum, current);
  }
}
