package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-02-24
 */
public class Q1524_M_NumberOfSubarraysWithOddSum {

  private static final int MOD = 1_000_000_007;

  public static void main(String[] args) {
    Q1524_M_NumberOfSubarraysWithOddSum q1524MNumberOfSubarraysWithOddSum =
        new Q1524_M_NumberOfSubarraysWithOddSum();
    System.out.println(q1524MNumberOfSubarraysWithOddSum.numOfSubarrays(new int[] {1, 3, 5}));
    System.out.println(q1524MNumberOfSubarraysWithOddSum.numOfSubarrays(new int[] {2, 4, 6}));
    System.out.println(
        q1524MNumberOfSubarraysWithOddSum.numOfSubarrays(new int[] {1, 2, 3, 4, 5, 6, 7}));
  }

  public int numOfSubarrays(int[] arr) {
    long sum = 0;
    int n = arr.length;
    int[] dp0 = new int[n + 1];
    int[] dp1 = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      if (arr[i - 1] % 2 == 1) {
        dp0[i] = dp1[i - 1];
        dp1[i] = dp0[i - 1] + 1;
      } else {
        dp0[i] = dp0[i - 1] + 1;
        dp1[i] = dp1[i - 1];
      }
      sum = (sum + dp1[i]) % MOD;
    }

    return (int) sum;
  }
}
