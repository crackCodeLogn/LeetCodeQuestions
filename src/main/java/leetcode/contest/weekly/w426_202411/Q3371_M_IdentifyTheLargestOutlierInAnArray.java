package leetcode.contest.weekly.w426_202411;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-11-30
 */
public class Q3371_M_IdentifyTheLargestOutlierInAnArray {

  private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
    mapper.put(key, mapper.getOrDefault(key, 0) + 1);
  }

  private static <K> void decreaseCount(Map<K, Integer> mapper, K key) {
    decreaseCount(mapper, key, 1);
  }

  private static <K> void decreaseCount(Map<K, Integer> mapper, K key, int decCnt) {
    Integer val = mapper.get(key);
    if (val == decCnt) mapper.remove(key);
    else mapper.put(key, val - decCnt);
  }

  public static void main(String[] args) {
    Q3371_M_IdentifyTheLargestOutlierInAnArray q3371MIdentifyTheLargestOutlierInAnArray =
        new Q3371_M_IdentifyTheLargestOutlierInAnArray();
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(new int[] {2, 3, 5, 10}));
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(new int[] {-2, -1, -3, -6, 4}));
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(
            new int[] {1, 1, 1, 1, 1, 5, 5}));
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(
            new int[] {166, -854, 166})); // -854
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(
            new int[] {-488, -64, -498, -160, -722})); // -488
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(
            new int[] {287, -355, -330, 114, -731})); // -355
    System.out.println(
        q3371MIdentifyTheLargestOutlierInAnArray.getLargestOutlier(
            new int[] {6, -31, 50, -35, 41, 37, -42, 13})); // -35
  }

  public int getLargestOutlier(int[] nums) {
    int n = nums.length, data = Integer.MIN_VALUE;
    int sum = Arrays.stream(nums).sum();
    Map<Integer, Integer> map = new HashMap<>();
    for (int val : nums) augmentCount(map, val);

    for (int i = n - 1; i >= 0; i--) {
      int v = sum - 2 * nums[i];
      decreaseCount(map, nums[i]);
      if (map.containsKey(v)) data = Math.max(data, v);
      augmentCount(map, nums[i]);
    }
    return data;
  }
}
