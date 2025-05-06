package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-05-05
 */
public class Q1920_E_BuildArrayFromPermutation {

  public static void main(String[] args) {
    Q1920_E_BuildArrayFromPermutation q1920EBuildArrayFromPermutation =
        new Q1920_E_BuildArrayFromPermutation();
    System.out.println(
        Arrays.toString(q1920EBuildArrayFromPermutation.buildArray(new int[] {0, 2, 1, 5, 3, 4})));
    System.out.println(
        Arrays.toString(q1920EBuildArrayFromPermutation.buildArray(new int[] {5, 0, 1, 2, 3, 4})));
  }

  public int[] buildArray(int[] nums) { // 1ms, beats 98.72%
    int n = nums.length;
    int[] data = new int[n];
    for (int i = 0; i < n; i++) data[i] = nums[nums[i]];
    return data;
  }
}
