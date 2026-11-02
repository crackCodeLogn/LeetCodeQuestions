package leetcode.practise;

import java.util.Arrays;

public class Q0462_M_MinimumMovesToEqualArrayElementsII {
  public int minMoves2(int[] nums) { // 11ms, beats 33.80%
    Arrays.sort(nums);
    int mid = nums[nums.length / 2];
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) cnt += Math.abs(mid - nums[i]);
    return cnt;
  }

  public static void main(String[] args) {
    Q0462_M_MinimumMovesToEqualArrayElementsII q0462MMinimumMovesToEqualArrayElementsII =
        new Q0462_M_MinimumMovesToEqualArrayElementsII();
    System.out.println(q0462MMinimumMovesToEqualArrayElementsII.minMoves2(new int[] {1, 2, 3}));
    System.out.println(q0462MMinimumMovesToEqualArrayElementsII.minMoves2(new int[] {1, 10, 2, 9}));
  }
}
