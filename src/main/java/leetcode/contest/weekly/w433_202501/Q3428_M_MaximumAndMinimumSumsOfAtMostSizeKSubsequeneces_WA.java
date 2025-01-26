package leetcode.contest.weekly.w433_202501;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-01-18
 */
public class Q3428_M_MaximumAndMinimumSumsOfAtMostSizeKSubsequeneces_WA {
  private static final int MOD = 1_000_000_007;

  public static void main(String[] args) {
    Q3428_M_MaximumAndMinimumSumsOfAtMostSizeKSubsequeneces_WA
        q3428MMaximumAndMinimumSumsOfAtMostSizeKSubsequeneces =
            new Q3428_M_MaximumAndMinimumSumsOfAtMostSizeKSubsequeneces_WA();
    System.out.println(
        q3428MMaximumAndMinimumSumsOfAtMostSizeKSubsequeneces.minMaxSums(
            new int[] {
              10, 5, 9, 9, 10, 10, 7, 7, 9, 6, 9, 6, 7, 6, 4, 9, 8, 4, 2, 0, 0, 3, 9, 3, 10, 3, 1,
              9, 8, 2, 8, 2, 0, 7, 7, 6, 4, 6, 7, 3, 2, 5, 6, 6, 5, 0, 5, 7, 8, 1
            },
            29)); // 428790069
    System.out.println(
        q3428MMaximumAndMinimumSumsOfAtMostSizeKSubsequeneces.minMaxSums(
            new int[] {0, 0, 0, 2}, 3)); // 16
    System.out.println(
        q3428MMaximumAndMinimumSumsOfAtMostSizeKSubsequeneces.minMaxSums(
            new int[] {1, 2, 3}, 2)); // 24
    System.out.println(
        q3428MMaximumAndMinimumSumsOfAtMostSizeKSubsequeneces.minMaxSums(
            new int[] {5, 0, 6}, 1)); // 22
    System.out.println(
        q3428MMaximumAndMinimumSumsOfAtMostSizeKSubsequeneces.minMaxSums(
            new int[] {1, 1, 1}, 2)); // 12
  }

  public int minMaxSums(int[] nums, int k) {
    Arrays.sort(nums);
    long sum = 0, baseSum = 0;
    int n = nums.length;
    for (int i = 0, v = n - 1, deficit = 1; i < n; i++, deficit++, v--) {
      baseSum += nums[i];

      long ls = 0;
      int k2 = 2;
      long comp = calcVal(n - i - 1, k2 - 1);
      while (k2++ <= k && comp > 0) {
        ls += comp;
        comp = calcVal(n - i - 1, k2 - 1);
      }
      sum = (sum + (nums[i] * ls) % MOD) % MOD;
      sum = (sum + (nums[v] * ls) % MOD) % MOD;
    }
    sum = (sum + baseSum * 2) % MOD;
    return (int) (sum % MOD);
  }

  /*public int minMaxSums(int[] nums, int k) {
    Arrays.sort(nums);
    long sum = 0, baseSum = 0;
    int n = nums.length;
    k--;
    for (int i = 0, v = n - 1, deficit = 1; i < n; i++, deficit++, v--) {
      baseSum += nums[i];

      long lc = n - deficit, ls = 0;
      int k2 = k;
      while (k2-- > 0 && lc > 0) {
        ls += lc;
        lc--;
      }
      sum += nums[i] * ls;
      sum += nums[v] * ls;
    }
    sum += baseSum * 2;
    return (int) (sum % MOD);
  }*/

  private long calcVal(int n, int k) {
    if (n < k) return 0;
    if (n == k) return 1;
    long val = 1;
    int down = n - k;
    for (int i = k + 1; i <= n; i++) {
      if (down > 1 && val % down == 0) {
        val /= down;
        down--;
      }
      val = (val * i) % MOD;
    }
    // for (int i = n - k; i >= 2; i--) val /= i;
    return val;
  }
}
