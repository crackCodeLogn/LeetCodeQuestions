package leetcode.practise;

import java.util.Arrays;

public class Q2567_M_MinimumScoreByChangingTwoElements {
  public int minimizeSum(int[] nums) { // 18ms, beats 88.54%
    int n = nums.length;
    if (n == 3) return 0;

    Arrays.sort(nums);
    int val = nums[n - 1] - nums[2]; // first 2 replaced with max
    val = Math.min(val, nums[n - 3] - nums[0]); // last 2 replaced with min
    return Math.min(val, nums[n - 2] - nums[1]); // ignore min and max
  }

  public static void main(String[] args) {
    Q2567_M_MinimumScoreByChangingTwoElements q2567MMinimumScoreByChangingTwoElements =
        new Q2567_M_MinimumScoreByChangingTwoElements();
    System.out.println(
        q2567MMinimumScoreByChangingTwoElements.minimizeSum(
            new int[] {13, 21, 21, 35, 52, 72, 74}));
    System.out.println(
        q2567MMinimumScoreByChangingTwoElements.minimizeSum(new int[] {9, 27, 33, 59, 81}));
    System.out.println(
        q2567MMinimumScoreByChangingTwoElements.minimizeSum(new int[] {1, 4, 7, 8, 5}));
    System.out.println(q2567MMinimumScoreByChangingTwoElements.minimizeSum(new int[] {1, 4, 3}));
  }
}
