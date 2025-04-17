package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-04-16
 */
public class Q2176_E_CountEqualAndDivisiblePairsInAnArray {

  public int countPairs(int[] nums, int k) {
    int cnt = 0, n = nums.length;
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++) if (nums[i] == nums[j] && (i * j) % k == 0) cnt++;
    return cnt;
  }
}
