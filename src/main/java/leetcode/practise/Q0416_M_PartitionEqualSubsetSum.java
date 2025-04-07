package leetcode.practise;

public class Q0416_M_PartitionEqualSubsetSum {

  public static void main(String[] args) {
    Q0416_M_PartitionEqualSubsetSum q0416MPartitionEqualSubsetSum =
        new Q0416_M_PartitionEqualSubsetSum();
    System.out.println(q0416MPartitionEqualSubsetSum.canPartition(new int[] {1, 5, 11, 5}));
    System.out.println(q0416MPartitionEqualSubsetSum.canPartition(new int[] {1, 2, 3, 5}));
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if ((sum & 1) == 1) return false;
    return compute(nums, sum / 2);
  }

  private boolean compute(int[] nums, int subsetSum) {
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][subsetSum + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      int num = nums[i - 1];
      for (int j = 0; j <= subsetSum; j++)
        dp[i][j] = j < num ? dp[i - 1][j] : (dp[i - 1][j] || dp[i - 1][j - num]);
    }
    return dp[n][subsetSum];
  }
}
