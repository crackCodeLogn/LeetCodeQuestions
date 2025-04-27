package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-04-26
 */
public class Q3392_E_CountSubarraysOfLengthThreeWithACondition {
  public static void main(String[] args) {
    Q3392_E_CountSubarraysOfLengthThreeWithACondition
        q3392ECountSubarraysOfLengthThreeWithACondition =
            new Q3392_E_CountSubarraysOfLengthThreeWithACondition();
    System.out.println(
        q3392ECountSubarraysOfLengthThreeWithACondition.countSubarrays(new int[] {-1, -4, -1, 4}));
    System.out.println(
        q3392ECountSubarraysOfLengthThreeWithACondition.countSubarrays(new int[] {1, 2, 1, 4, 1}));
    System.out.println(
        q3392ECountSubarraysOfLengthThreeWithACondition.countSubarrays(new int[] {1, 1, 1}));
  }

  public int countSubarrays(int[] nums) { // 1ms, beats 100%
    int cnt = 0, n = nums.length;
    /*for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isOdd(nums[j])) continue;
        int val = nums[j] / 2;
        for (int k = j + 1; k < n; k++) if (nums[i] + nums[k] == val) cnt++;
      }
    }*/
    for (int i = 0; i < n - 2; i++) {
      if (isOdd(nums[i + 1])) continue;
      if (nums[i] + nums[i + 2] == nums[i + 1] / 2) cnt++;
    }
    return cnt;
  }

  private boolean isOdd(int num) {
    return (num & 1) == 1;
  }
}
