package leetcode.contest.weekly.w429_202412;

/**
 * @author Vivek
 * @since 2024-12-21
 */
public class Q3396_E_MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

  public static void main(String[] args) {
    Q3396_E_MinimumNumberOfOperationsToMakeElementsInArrayDistinct
        q3396EMinimumNumberOfOperationsToMakeElementsInArrayDistinct =
            new Q3396_E_MinimumNumberOfOperationsToMakeElementsInArrayDistinct();
    System.out.println(
        q3396EMinimumNumberOfOperationsToMakeElementsInArrayDistinct.minimumOperations(
            new int[] {1, 2, 3, 4, 2, 3, 3, 5, 7}));
    System.out.println(
        q3396EMinimumNumberOfOperationsToMakeElementsInArrayDistinct.minimumOperations(
            new int[] {4, 5, 6, 4, 4}));
    System.out.println(
        q3396EMinimumNumberOfOperationsToMakeElementsInArrayDistinct.minimumOperations(
            new int[] {6, 7, 8, 9}));
    System.out.println(
        q3396EMinimumNumberOfOperationsToMakeElementsInArrayDistinct.minimumOperations(
            new int[] {5, 7, 11, 12, 12})); // 2
  }

  public int minimumOperations(int[] nums) {
    int[] count = new int[101];
    int ops = 0, ptr = 0;
    for (int num : nums) count[num]++;
    if (isDistinct(count)) return 0;

    while (true) {
      ops++;
      if (ptr >= nums.length - 3) {
        break;
      }
      count[nums[ptr++]]--;
      count[nums[ptr++]]--;
      count[nums[ptr++]]--;
      if (isDistinct(count)) break;
    }
    return ops;
  }

  private boolean isDistinct(int[] cnt) {
    for (int cnt1 : cnt) if (cnt1 > 1) return false;
    return true;
  }
}
