package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2026-01-24
 */
public class Q1984_E_MinimumDifferenceBetweenHighestAndLowestOfKScores {
  public static void main(String[] args) {
    Q1984_E_MinimumDifferenceBetweenHighestAndLowestOfKScores
        q1984EMinimumDifferenceBetweenHighestAndLowestOfKScores =
            new Q1984_E_MinimumDifferenceBetweenHighestAndLowestOfKScores();
    System.out.println(
        q1984EMinimumDifferenceBetweenHighestAndLowestOfKScores.minimumDifference(
            new int[] {90}, 1));
    System.out.println(
        q1984EMinimumDifferenceBetweenHighestAndLowestOfKScores.minimumDifference(
            new int[] {9, 5, 1, 7}, 2));
  }

  public int minimumDifference(int[] nums, int k) { // 7ms, beats 99.17%
    Arrays.sort(nums);
    int p1 = 0, p2 = k - 1, delta = Integer.MAX_VALUE;
    while (p2 < nums.length) {
      int del = nums[p2] - nums[p1];
      if (del < delta) delta = del;
      p2++;
      p1++;
    }
    return delta;
  }
}
