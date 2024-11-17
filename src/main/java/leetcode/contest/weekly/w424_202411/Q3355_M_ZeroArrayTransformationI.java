package leetcode.contest.weekly.w424_202411;

/**
 * @author Vivek
 * @since 2024-11-16
 *     <ol>
 *       <li>#LEARNING
 *       <li>Concept: DIFFERENCE ARRAY
 *     </ol>
 *     Works for this use-case because specifically it involves steps of size 1 only
 */
public class Q3355_M_ZeroArrayTransformationI {

  public static void main(String[] args) {
    Q3355_M_ZeroArrayTransformationI q3355MZeroArrayTransformationI =
        new Q3355_M_ZeroArrayTransformationI();
    System.out.println(
        q3355MZeroArrayTransformationI.isZeroArray(new int[] {1, 0, 1}, new int[][] {{0, 2}}));
    System.out.println(
        q3355MZeroArrayTransformationI.isZeroArray(
            new int[] {4, 3, 2, 1}, new int[][] {{1, 3}, {0, 2}}));
  }

  // Makes use of DIFFERENCE ARRAY -> Important tool to handle operations like incrementing and
  // decrementing a range of elements in an array
  public boolean isZeroArray(int[] nums, int[][] queries) { // AC
    int n = nums.length;
    int[] delta = new int[n];
    for (int q = 0; q < queries.length; q++) {
      int src = queries[q][0], dest = queries[q][1];
      delta[src]++; // updating the fringes only
      if (dest + 1 < n) delta[dest + 1]--; // updating the fringes only
    }
    for (int i = 1; i < n; i++) delta[i] += delta[i - 1]; // populates with prefix sum!
    for (int i = 0; i < n; i++)
      if (delta[i] < nums[i]) return false; // check prefix sum being able to cross over
    return true;
  }

  public boolean isZeroArray2(int[] nums, int[][] queries) { // TLE
    int n = nums.length;
    int cnt = 0;
    boolean[] data = new boolean[n];
    for (int i = 0; i < n; i++)
      if (nums[i] == 0) {
        data[i] = true;
        cnt++;
      }
    for (int q = 0; q < queries.length; q++) {
      int src = queries[q][0], dest = queries[q][1];
      for (int k = src; k <= dest; k++) {
        if (data[k]) continue;
        nums[k]--;
        if (nums[k] == 0) {
          data[k] = true;
          cnt++;
        }
      }
    }
    return cnt == n;
  }
}
