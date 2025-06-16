package leetcode.practise;

import static org.junit.Assert.assertEquals;

public class Q2016_E_MaximumDifferenceBetweenIncreasingElements {

  public static void main(String[] args) {
    Q2016_E_MaximumDifferenceBetweenIncreasingElements
        q2016EMaximumDifferenceBetweenIncreasingElements =
            new Q2016_E_MaximumDifferenceBetweenIncreasingElements();
    assertEquals(
        4,
        q2016EMaximumDifferenceBetweenIncreasingElements.maximumDifference(new int[] {7, 1, 5, 4}));
    assertEquals(
        -1,
        q2016EMaximumDifferenceBetweenIncreasingElements.maximumDifference(new int[] {9, 4, 3, 2}));
    assertEquals(
        9,
        q2016EMaximumDifferenceBetweenIncreasingElements.maximumDifference(
            new int[] {1, 5, 2, 10}));
  }

  public int maximumDifference(int[] nums) {
    int n = nums.length;
    int[] mins = new int[n];
    mins[0] = nums[0];
    int[] maxs = new int[n];
    maxs[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) mins[i] = Math.min(mins[i - 1], nums[i]);
    for (int i = n - 2; i >= 0; i--) maxs[i] = Math.max(maxs[i + 1], nums[i]);
    int v = 0;
    for (int i = 0; i < n; i++) v = Math.max(v, Math.abs(maxs[i] - mins[i]));
    return v > 0 ? v : -1;
  }
}
