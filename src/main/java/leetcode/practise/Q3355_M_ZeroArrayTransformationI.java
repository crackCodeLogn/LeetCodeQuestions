package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-05-19
 */
public class Q3355_M_ZeroArrayTransformationI {

  public static void main(String[] args) {
    Q3355_M_ZeroArrayTransformationI q3355MZeroArrayTransformationI =
        new Q3355_M_ZeroArrayTransformationI();
    System.out.println(
        q3355MZeroArrayTransformationI.isZeroArray(new int[] {1, 0, 1}, new int[][] {{0, 2}}));
    System.out.println(
        q3355MZeroArrayTransformationI.isZeroArray(
            new int[] {4, 3, 2, 1},
            new int[][] {
              {1, 3},
              {0, 2},
            }));
  }

  public boolean isZeroArray(int[] nums, int[][] queries) { // 3ms, beats 79.52%
    int n = nums.length;
    int[] delta = new int[n];
    for (int q = 0; q < queries.length; q++) {
      int src = queries[q][0], dest = queries[q][1];
      delta[src]++;
      if (dest + 1 < n) delta[dest + 1]--;
    }
    for (int i = 1; i < n; i++) delta[i] += delta[i - 1];
    for (int i = 0; i < n; i++) if (delta[i] < nums[i]) return false;
    return true;
  }
}
