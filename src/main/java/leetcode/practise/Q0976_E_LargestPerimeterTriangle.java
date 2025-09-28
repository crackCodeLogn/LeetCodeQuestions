package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 9/27/25
 */
public class Q0976_E_LargestPerimeterTriangle {

  public static void main(String[] args) {
    Q0976_E_LargestPerimeterTriangle q0976ELargestPerimeterTriangle =
        new Q0976_E_LargestPerimeterTriangle();
    System.out.println(q0976ELargestPerimeterTriangle.largestPerimeter(new int[] {2, 1, 2}));
    System.out.println(q0976ELargestPerimeterTriangle.largestPerimeter(new int[] {1, 2, 1, 10}));
  }

  public int largestPerimeter(int[] nums) { // 7ms, beats 99.49%
    Arrays.sort(nums);
    for (int i = nums.length - 1; i > 1; i--)
      if (nums[i - 2] + nums[i - 1] > nums[i]) return nums[i] + nums[i - 1] + nums[i - 2];
    return 0;
  }
}
