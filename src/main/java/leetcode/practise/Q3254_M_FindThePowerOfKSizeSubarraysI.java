package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-11-15
 */
public class Q3254_M_FindThePowerOfKSizeSubarraysI {
  public static void main(String[] args) {
    Q3254_M_FindThePowerOfKSizeSubarraysI q3254MFindThePowerOfKSizeSubarraysI =
        new Q3254_M_FindThePowerOfKSizeSubarraysI();
    System.out.println(
        Arrays.toString(
            q3254MFindThePowerOfKSizeSubarraysI.resultsArray(new int[] {1, 2, 3, 4, 3, 2, 5}, 3)));
    System.out.println(
        Arrays.toString(
            q3254MFindThePowerOfKSizeSubarraysI.resultsArray(new int[] {2, 2, 2, 2, 2}, 4)));
    System.out.println(
        Arrays.toString(
            q3254MFindThePowerOfKSizeSubarraysI.resultsArray(new int[] {3, 2, 3, 2, 3, 2}, 2)));
    System.out.println(
        Arrays.toString(q3254MFindThePowerOfKSizeSubarraysI.resultsArray(new int[] {1, 3, 4}, 2)));
  }

  public int[] resultsArray(int[] nums, int k) { // 1ms
    int n = nums.length;
    int[] data = new int[n - k + 1];
    Arrays.fill(data, -1);
    if (k == 1) return nums;

    if (isConsecutive(nums, 0, k - 1)) data[0] = nums[k - 1];

    for (int i = k, m = 1; i < n; i++, m++) {
      if (data[m - 1] == -1) {
        if (isConsecutive(nums, i - k + 1, i)) {
          data[m] = nums[i];
        }
      } else if (nums[i] == data[m - 1] + 1) {
        data[m] = nums[i];
      } else {
        i += k - 2;
        m += k - 2;
      }
    }
    return data;
  }

  private boolean isConsecutive(int[] nums, int start, int end) {
    for (int i = start + 1; i <= end; i++) if (nums[i] != nums[i - 1] + 1) return false;
    return true;
  }
}
