package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-05-18
 */
public class Q3024_E_TypeOfTriangle {

  public static void main(String[] args) {
    Q3024_E_TypeOfTriangle q3024ETypeOfTriangle = new Q3024_E_TypeOfTriangle();
    System.out.println(q3024ETypeOfTriangle.triangleType(new int[] {3, 3, 3}));
    System.out.println(q3024ETypeOfTriangle.triangleType(new int[] {3, 4, 5}));
    System.out.println(q3024ETypeOfTriangle.triangleType(new int[] {5, 3, 8}));
  }

  public String triangleType(int[] nums) { // 1ms, beats 34.56%
    Arrays.sort(nums);
    if (nums[0] + nums[1] <= nums[2]) return "none";
    if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
    if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) return "isosceles";
    return "scalene";
  }
}
