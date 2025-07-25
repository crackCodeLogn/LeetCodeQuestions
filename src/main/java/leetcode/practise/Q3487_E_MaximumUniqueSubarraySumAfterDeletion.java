package leetcode.practise;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 7/24/25
 */
public class Q3487_E_MaximumUniqueSubarraySumAfterDeletion {

  public static void main(String[] args) {
    Q3487_E_MaximumUniqueSubarraySumAfterDeletion q3487EMaximumUniqueSubarraySumAfterDeletion =
        new Q3487_E_MaximumUniqueSubarraySumAfterDeletion();
    System.out.println(
        q3487EMaximumUniqueSubarraySumAfterDeletion.maxSum(new int[] {1, 2, 3, 4, 5}));
    System.out.println(
        q3487EMaximumUniqueSubarraySumAfterDeletion.maxSum(new int[] {1, 1, 0, 1, 1}));
    System.out.println(
        q3487EMaximumUniqueSubarraySumAfterDeletion.maxSum(new int[] {1, 2, -1, -2, 1, 0, -1}));
  }

  public int maxSum(int[] nums) { // 2ms, beats 74.06%
    int val, n = nums.length;
    Arrays.sort(nums);
    if (nums[n - 1] < 0) return nums[n - 1];
    val = nums[n - 1];
    for (int i = n - 2; i >= 0 && nums[i] >= 0; i--) if (nums[i] != nums[i + 1]) val += nums[i];
    return val;
  }

  public int maxSum2(int[] nums) { // 3ms, beats 20.94%
    int val = -1000;
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums) set.add(num);
    for (int num : set) {
      if (num < 0) continue;
      if (val == -1000) val = 0;
      val += num;
    }
    return val == -1000 ? set.last() : val;
  }
}
