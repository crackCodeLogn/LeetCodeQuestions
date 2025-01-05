package leetcode.contest.weekly.w431_202501;

/**
 * @author Vivek
 * @since 2025-01-04
 */
public class Q3411_E_MaximumSubarrayWithEqualProducts {

  private static int getGcd(int a, int b) {
    if (a == 0) return b;
    return getGcd(b % a, a);
  }

  private static int getLcm(int a, int b) {
    return (a * b) / getGcd(a, b);
  }

  public static void main(String[] args) {
    Q3411_E_MaximumSubarrayWithEqualProducts q3411EMaximumSubarrayWithEqualProducts =
        new Q3411_E_MaximumSubarrayWithEqualProducts();
    System.out.println(
        q3411EMaximumSubarrayWithEqualProducts.maxLength(new int[] {1, 2, 1, 2, 1, 1, 1}));
    System.out.println(q3411EMaximumSubarrayWithEqualProducts.maxLength(new int[] {2, 3, 4, 5, 6}));
    System.out.println(
        q3411EMaximumSubarrayWithEqualProducts.maxLength(new int[] {1, 2, 3, 1, 4, 5, 1}));
  }

  public int maxLength(int[] nums) {
    int maxLen = 0, n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int prod = nums[i];
        int gcd = nums[i];
        int lcm = nums[i];
        for (int k = i + 1; k <= j; k++) {
          prod *= nums[k];
          gcd = getGcd(gcd, nums[k]);
          lcm = getLcm(lcm, nums[k]);
        }
        if (prod == lcm * gcd) {
          maxLen = Math.max(maxLen, j - i + 1);
        }
      }
    }

    return maxLen;
  }
}
