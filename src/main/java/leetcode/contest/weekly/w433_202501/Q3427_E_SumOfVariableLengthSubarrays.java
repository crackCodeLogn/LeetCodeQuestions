package leetcode.contest.weekly.w433_202501;

/**
 * @author Vivek
 * @since 2025-01-18
 */
public class Q3427_E_SumOfVariableLengthSubarrays {

  public static void main(String[] args) {
    Q3427_E_SumOfVariableLengthSubarrays q3427ESumOfVariableLengthSubarrays =
        new Q3427_E_SumOfVariableLengthSubarrays();
    System.out.println(q3427ESumOfVariableLengthSubarrays.subarraySum(new int[] {2, 3, 1}));
    System.out.println(q3427ESumOfVariableLengthSubarrays.subarraySum(new int[] {3, 1, 1, 2}));
  }

  public int subarraySum(int[] nums) {
    int sum = 0, n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = Math.max(0, i - nums[i]); j <= i; j++) {
        sum += nums[j];
      }
    }
    return sum;
  }
}
