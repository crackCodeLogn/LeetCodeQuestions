package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-03-15
 */
public class Q2560_M_HouseRobberIV {

  public static void main(String[] args) {
    Q2560_M_HouseRobberIV q2560MHouseRobberIV = new Q2560_M_HouseRobberIV();
    System.out.println(q2560MHouseRobberIV.minCapability(new int[] {2, 3, 5, 9}, 2));
    System.out.println(q2560MHouseRobberIV.minCapability(new int[] {2, 7, 9, 3, 1}, 2));
  }

  public int minCapability(int[] nums, int k) {
    int min = nums[0], max = nums[0], n = nums.length;
    for (int i = 1; i < n; i++) {
      if (nums[i] < min) min = nums[i];
      if (nums[i] > max) max = nums[i];
    }
    int lb = min, ub = max, mid;
    while (lb <= ub) {
      mid = lb + (ub - lb) / 2;
      if (compute(nums, mid) >= k) ub = mid - 1;
      else lb = mid + 1;
    }
    return lb;
  }

  private int compute(int[] nums, int cap) {
    int cnt = 0;
    for (int i = 0; i < nums.length; i++)
      if (nums[i] <= cap) {
        cnt++;
        i++; // bump for skip adj
      }
    return cnt;
  }
}
