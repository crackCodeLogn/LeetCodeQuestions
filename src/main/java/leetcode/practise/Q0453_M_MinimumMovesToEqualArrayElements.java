package leetcode.practise;

import java.util.Arrays;

public class Q0453_M_MinimumMovesToEqualArrayElements {

  public int minMoves(int[] nums) { // 2ms, beats 94.49%
    int cnt = 0;
    int min = nums[0];
    //    for (int i = 0; i < nums.length; i++) min = Math.min(min, nums[i]);
    for (int i = 0; i < nums.length; i++)
      if (nums[i] < min) min = nums[i]; // this is 1ms faster than above line
    for (int i = 0; i < nums.length; i++) cnt += nums[i] - min;
    return cnt;
  }

  public int minMoves2(int[] nums) { // 6ms, beats 12.18%
    int cnt = 0;
    int min = Arrays.stream(nums).min().getAsInt();
    for (int num : nums) cnt += num - min;
    return cnt;
  }

  public static void main(String[] args) {
    Q0453_M_MinimumMovesToEqualArrayElements q0453MMinimumMovesToEqualArrayElements =
        new Q0453_M_MinimumMovesToEqualArrayElements();
    System.out.println(q0453MMinimumMovesToEqualArrayElements.minMoves(new int[] {1, 1, 10, 12}));
    System.out.println(q0453MMinimumMovesToEqualArrayElements.minMoves(new int[] {1, 2, 3, 4}));
    System.out.println(q0453MMinimumMovesToEqualArrayElements.minMoves(new int[] {1, 2, 3}));
    System.out.println(q0453MMinimumMovesToEqualArrayElements.minMoves(new int[] {1, 1, 1}));
  }
}
