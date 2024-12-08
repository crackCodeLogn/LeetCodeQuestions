package leetcode.contest.weekly.w427_202412;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-12-07
 */
public class Q3379_E_TransformedArray {

  public static void main(String[] args) {
    Q3379_E_TransformedArray q3379ETransformedArray = new Q3379_E_TransformedArray();
    System.out.println(
        Arrays.toString(q3379ETransformedArray.constructTransformedArray(new int[] {3, -2, 1, 1})));
    System.out.println(
        Arrays.toString(q3379ETransformedArray.constructTransformedArray(new int[] {-1, 4, -1})));
  }

  public int[] constructTransformedArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int val = nums[i];
      if (val == 0) {
        result[i] = val;
        continue;
      }
      int factor = val > 0 ? 1 : -1, j = i;
      val = Math.abs(val);
      while (val-- > 0) {
        j += factor;
        if (j == n) j = 0;
        else if (j == -1) j = n - 1;
      }
      result[i] = nums[j];
    }
    return result;
  }
}
