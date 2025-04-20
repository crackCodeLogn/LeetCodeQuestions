package leetcode.contest.weekly.w446_202504;

/**
 * @author Vivek
 * @since 2025-04-19
 */
public class Q3523_M_MakeArrayNonDecreasing {

  public static void main(String[] args) {
    Q3523_M_MakeArrayNonDecreasing q3523MMakeArrayNonDecreasing =
        new Q3523_M_MakeArrayNonDecreasing();
    System.out.println(q3523MMakeArrayNonDecreasing.maximumPossibleSize(new int[] {4, 2, 5, 3, 5}));
    System.out.println(q3523MMakeArrayNonDecreasing.maximumPossibleSize(new int[] {4, 4, 4}));
    System.out.println(
        q3523MMakeArrayNonDecreasing.maximumPossibleSize(new int[] {4, 4, 4, 5, 6, 7}));
    System.out.println(
        q3523MMakeArrayNonDecreasing.maximumPossibleSize(new int[] {4, 4, 4, 15, 6, 7}));
    System.out.println(
        q3523MMakeArrayNonDecreasing.maximumPossibleSize(new int[] {4, 4, 4, 15, 6, 17}));
    System.out.println(q3523MMakeArrayNonDecreasing.maximumPossibleSize(new int[] {1, 2, 3}));
  }

  public int maximumPossibleSize(int[] nums) {
    if (nums.length == 1) return 1;
    int current = nums[0];
    int cnt = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] >= current) {
        current = nums[i];
        cnt++;
      }
    }
    return cnt;
  }
}
