package leetcode.contest.weekly.w439_202502;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2025-03-01
 */
public class Q3471_E_FindTheLargestAlmostMissingInteger {

  public static void main(String[] args) {
    Q3471_E_FindTheLargestAlmostMissingInteger q3471EFindTheLargestAlmostMissingInteger = new Q3471_E_FindTheLargestAlmostMissingInteger();
    System.out.println(q3471EFindTheLargestAlmostMissingInteger.largestInteger(new int[] {0, 0}, 2));
    System.out.println(q3471EFindTheLargestAlmostMissingInteger.largestInteger(new int[] {3, 1, 7, 10, 0}, 1));
    System.out.println(q3471EFindTheLargestAlmostMissingInteger.largestInteger(new int[] {3, 7, 7, 10, 10}, 1));
    System.out.println(q3471EFindTheLargestAlmostMissingInteger.largestInteger(new int[] {3, 9, 2, 1, 7}, 3));
    System.out.println(q3471EFindTheLargestAlmostMissingInteger.largestInteger(new int[] {3, 9, 7, 2, 1, 7}, 4));
    System.out.println(q3471EFindTheLargestAlmostMissingInteger.largestInteger(new int[] {0, 0}, 1));
  }

  public int largestInteger(int[] nums, int k) {
    if (nums.length == 1) return -1;
    if (k == nums.length) return Arrays.stream(nums).max().getAsInt();
    if (k == 1) {
      return find(nums);
    }
    if (nums[0] == nums[nums.length - 1]) return -1;
    boolean b1 = compute(nums, nums[0]), b2 = compute(nums, nums[nums.length - 1]);
    if (b1 && b2) return Math.max(nums[0], nums[nums.length - 1]);
    if (b1) return nums[0];
    if (b2) return nums[nums.length - 1];
    return -1;
  }

  private int find(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int val : nums) map.put(val, map.getOrDefault(val, 0) + 1);

    while (!map.isEmpty()) {
      Map.Entry<Integer, Integer> entry = map.pollLastEntry();
      if (entry.getValue() == 1) return entry.getKey();
    }
    return -1;
  }

  private boolean compute(int[] nums, int v) {
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) if (nums[i] == v) cnt++;
    return cnt == 1;
  }
}
