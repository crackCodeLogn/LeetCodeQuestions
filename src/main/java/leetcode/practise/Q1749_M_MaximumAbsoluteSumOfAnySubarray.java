package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-02-25
 */
public class Q1749_M_MaximumAbsoluteSumOfAnySubarray {

  public static void main(String[] args) {
    Q1749_M_MaximumAbsoluteSumOfAnySubarray q1749MMaximumAbsoluteSumOfAnySubarray =
        new Q1749_M_MaximumAbsoluteSumOfAnySubarray();
    System.out.println(
        q1749MMaximumAbsoluteSumOfAnySubarray.maxAbsoluteSum(new int[] {1, -3, 2, 3, -4}));
    System.out.println(
        q1749MMaximumAbsoluteSumOfAnySubarray.maxAbsoluteSum(new int[] {2, -5, 1, -4, 3, -2}));
  }

  public int maxAbsoluteSum(int[] nums) {
    int ans = Integer.MIN_VALUE, maxSum = 0, minSum = 0;
    for (int num : nums) {
      maxSum = Math.max(num, maxSum + num);
      minSum = Math.min(num, minSum + num);
      ans = Math.max(ans, Math.max(maxSum, -minSum));
    }
    return ans;
  }
}
