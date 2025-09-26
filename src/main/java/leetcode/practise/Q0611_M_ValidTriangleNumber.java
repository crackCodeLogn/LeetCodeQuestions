package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 9/26/25
 */
public class Q0611_M_ValidTriangleNumber {

  public static void main(String[] args) {
    Q0611_M_ValidTriangleNumber q0611MValidTriangleNumber = new Q0611_M_ValidTriangleNumber();
    System.out.println(q0611MValidTriangleNumber.triangleNumber(new int[] {2, 2, 3, 4}));
    System.out.println(q0611MValidTriangleNumber.triangleNumber(new int[] {4, 2, 3, 4}));
    System.out.println(q0611MValidTriangleNumber.triangleNumber(new int[] {1, 1, 1, 1, 1}));
  }

  public int triangleNumber(int[] nums) {
    if (nums.length < 3) return 0;
    int cnt = 0;
    Arrays.sort(nums);

    for (int k = nums.length - 1; k > 1; k--) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          cnt += j - i;
          j--;
        } else i++;
      }
    }
    return cnt;
  }
}
