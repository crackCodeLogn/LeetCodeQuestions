package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2026-04-10
 */
public class Q3740_E_MinimumDistanceBetweenThreeEqualElementsI {
  public static void main(String[] args) {
    Q3740_E_MinimumDistanceBetweenThreeEqualElementsI
        q3740MinimumDistanceBetweenThreeEqualElementsI =
            new Q3740_E_MinimumDistanceBetweenThreeEqualElementsI();
    System.out.println(
        q3740MinimumDistanceBetweenThreeEqualElementsI.minimumDistance(new int[] {1, 2, 1, 1, 3}));
    System.out.println(
        q3740MinimumDistanceBetweenThreeEqualElementsI.minimumDistance(
            new int[] {1, 1, 2, 3, 2, 1, 2}));
    System.out.println(
        q3740MinimumDistanceBetweenThreeEqualElementsI.minimumDistance(new int[] {1}));
  }

  public int minimumDistance(int[] nums) { // 4ms, beats 68.49%
    Map<Integer, List<Integer>> data = new HashMap<>();
    for (int i = 0; i < nums.length; i++)
      data.compute(nums[i], (k, v) -> v == null ? new ArrayList<>() : v).add(i);
    int min = Integer.MAX_VALUE;
    for (List<Integer> list : data.values())
      if (list.size() >= 3)
        for (int i = 0; i <= list.size() - 3; i++) {
          int cur =
              Math.abs(list.get(i) - list.get(i + 1))
                  + Math.abs(list.get(i + 1) - list.get(i + 2))
                  + Math.abs(list.get(i + 2) - list.get(i));
          if (cur < min) min = cur;
        }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
