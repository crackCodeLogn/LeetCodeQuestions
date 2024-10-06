package leetcode.contest.weekly.w418_202410;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-10-05
 */
public class Q3309_M_MaximumPossibleNumberByBinaryConcatenation {
  private final Map<Integer, String> map = new HashMap<>();
  private int[] nums;

  public static void main(String[] args) {
    Q3309_M_MaximumPossibleNumberByBinaryConcatenation
        q3309MMaximumPossibleNumberByBinaryConcatenation =
            new Q3309_M_MaximumPossibleNumberByBinaryConcatenation();
    System.out.println(
        q3309MMaximumPossibleNumberByBinaryConcatenation.maxGoodNumber(new int[] {1, 2, 3}));
    System.out.println(
        q3309MMaximumPossibleNumberByBinaryConcatenation.maxGoodNumber(new int[] {2, 8, 16}));
  }

  public int maxGoodNumber(int[] nums) {
    map.clear();
    this.nums = nums;
    map.put(nums[0], Integer.toBinaryString(nums[0]));
    map.put(nums[1], Integer.toBinaryString(nums[1]));
    map.put(nums[2], Integer.toBinaryString(nums[2]));

    int max = -1;
    max = Math.max(max, permute(0, 1, 2));
    max = Math.max(max, permute(0, 2, 1));
    max = Math.max(max, permute(1, 0, 2));
    max = Math.max(max, permute(1, 2, 0));
    max = Math.max(max, permute(2, 0, 1));
    max = Math.max(max, permute(2, 1, 0));
    return max;
  }

  private int permute(int n1, int n2, int n3) {
    return Integer.parseInt(
        String.format("%s%s%s", map.get(nums[n1]), map.get(nums[n2]), map.get(nums[n3])), 2);
  }
}
