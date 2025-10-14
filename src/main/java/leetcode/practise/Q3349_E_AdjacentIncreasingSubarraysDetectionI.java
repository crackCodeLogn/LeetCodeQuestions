package leetcode.practise;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author Vivek
 * @since 10/13/25
 */
public class Q3349_E_AdjacentIncreasingSubarraysDetectionI {

  public static void main(String[] args) {
    Q3349_E_AdjacentIncreasingSubarraysDetectionI q3349EAdjacentIncreasingSubarraysDetectionI =
        new Q3349_E_AdjacentIncreasingSubarraysDetectionI();
    System.out.println(
        q3349EAdjacentIncreasingSubarraysDetectionI.hasIncreasingSubarrays(
            Lists.newArrayList(0, -19, -18, 12, -20, -16), 3));
    System.out.println(
        q3349EAdjacentIncreasingSubarraysDetectionI.hasIncreasingSubarrays(
            Lists.newArrayList(-15, 19), 1));
    System.out.println(
        q3349EAdjacentIncreasingSubarraysDetectionI.hasIncreasingSubarrays(
            Lists.newArrayList(-3, -19, -8, -16), 2));
    System.out.println(
        q3349EAdjacentIncreasingSubarraysDetectionI.hasIncreasingSubarrays(
            Lists.newArrayList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
    System.out.println(
        q3349EAdjacentIncreasingSubarraysDetectionI.hasIncreasingSubarrays(
            Lists.newArrayList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5));
  }

  public boolean hasIncreasingSubarrays(List<Integer> nums, int k) { // 1ms, beats 100%
    for (int i = 0; i < nums.size() - k; i++)
      if (inc(nums, i, i + k - 1) && inc(nums, i + k, i + 2 * k - 1)) return true;
    return false;
  }

  private boolean inc(List<Integer> data, int a, int b) {
    if (b == a) return true;
    if (a + 1 >= data.size() || b >= data.size()) return false;
    for (int i = a + 1; i <= b; i++) if (data.get(i) <= data.get(i - 1)) return false;
    return true;
  }
}
