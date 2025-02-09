package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-02-08
 */
public class Q2364_M_CountNumberOfBadPairs {

  public static void main(String[] args) {
    Q2364_M_CountNumberOfBadPairs q2364MCountNumberOfBadPairs = new Q2364_M_CountNumberOfBadPairs();
    System.out.println(q2364MCountNumberOfBadPairs.countBadPairs(new int[] {4, 1, 3, 3}));
    System.out.println(q2364MCountNumberOfBadPairs.countBadPairs(new int[] {1, 2, 3, 4, 5}));
  }

  public long countBadPairs(int[] nums) { // 41ms, beats 49.41%
    Map<Integer, Long> map = new HashMap<>();
    long count = nc2(nums.length);

    for (int i = 0; i < nums.length; i++) {
      int diff = nums[i] - i;
      map.put(diff, map.getOrDefault(diff, 0L) + 1L);
    }
    for (long val : map.values()) count -= nc2(val);

    return count;
  }

  private long nc2(long n) {
    return n * (n - 1) / 2;
  }
}
