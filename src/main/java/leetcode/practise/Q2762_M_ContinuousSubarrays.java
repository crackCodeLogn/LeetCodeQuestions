package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-14
 */
public class Q2762_M_ContinuousSubarrays {

  public static void main(String[] args) {
    Q2762_M_ContinuousSubarrays q2762MContinuousSubarrays = new Q2762_M_ContinuousSubarrays();
    System.out.println(q2762MContinuousSubarrays.continuousSubarrays(new int[] {5, 4, 2, 4}));
    System.out.println(q2762MContinuousSubarrays.continuousSubarrays(new int[] {1, 2, 3}));
  }

  public long continuousSubarrays(int[] nums) {
    long result = 1;
    int left = nums[0] - 2;
    int right = nums[0] + 2;
    int l = 0;

    for (int r = 1; r < nums.length; r++) {
      if (left <= nums[r] && nums[r] <= right) {
        left = Math.max(left, nums[r] - 2);
        right = Math.min(right, nums[r] + 2);
      } else {
        left = nums[r] - 2;
        right = nums[r] + 2;
        l = r;
        while (nums[r] - 2 <= nums[l] && nums[l] <= nums[r] + 2) {
          left = Math.max(left, nums[l] - 2);
          right = Math.min(right, nums[l] + 2);
          l--;
        }
        l++;
      }
      result += r - l + 1;
    }

    return result;
  }
}
