package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-11-08
 */
public class Q1829_M_MaximumXorForEachQuery {
  public static void main(String[] args) {
    Q1829_M_MaximumXorForEachQuery q1829MMaximumXorForEachQuery =
        new Q1829_M_MaximumXorForEachQuery();
    System.out.println(
        Arrays.toString(q1829MMaximumXorForEachQuery.getMaximumXor(new int[] {0, 1, 1, 3}, 2)));
    System.out.println(
        Arrays.toString(q1829MMaximumXorForEachQuery.getMaximumXor(new int[] {2, 3, 4, 7}, 3)));
    System.out.println(
        Arrays.toString(
            q1829MMaximumXorForEachQuery.getMaximumXor(new int[] {0, 1, 2, 2, 5, 7}, 3)));
  }

  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int n = nums.length, k = n - 1;
    int[] result = new int[n];
    int xor = nums[0];
    result[k--] = getK(xor, maximumBit);
    for (int i = 1; i < n; i++) {
      xor ^= nums[i];
      result[k--] = getK(xor, maximumBit);
    }
    return result;
  }

  private int getK(int xor, int maxBit) {
    int max = (int) Math.pow(2, maxBit) - 1;
    if (xor == 0) return max;
    StringBuilder data = new StringBuilder();
    while (max > 0) {
      boolean set = (xor & 1) == 1;
      data.append(set ? 0 : 1);
      xor >>= 1;
      max >>= 1;
    }
    return Integer.parseInt(data.reverse().toString(), 2);
  }
}
