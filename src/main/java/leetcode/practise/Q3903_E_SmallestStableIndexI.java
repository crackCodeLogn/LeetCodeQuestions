package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-09-03
 */
public class Q3903_E_SmallestStableIndexI {
  public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;
    int[] max = new int[n];
    int[] min = new int[n];
    max[0] = nums[0];
    min[n - 1] = nums[n - 1];
    for (int i = 1, j = n - 2; i < n; i++, j--) {
      max[i] = Math.max(max[i - 1], nums[i]);
      min[j] = Math.min(min[j + 1], nums[j]);
    }
    for (int i = 0; i < n; i++) if (max[i] - min[i] <= k) return i;
    return -1;
  }

  public static void main(String[] args) {
    Q3903_E_SmallestStableIndexI q3903ESmallestStableIndexI = new Q3903_E_SmallestStableIndexI();
    System.out.println(q3903ESmallestStableIndexI.firstStableIndex(new int[] {5, 0, 1, 4}, 3));
    System.out.println(q3903ESmallestStableIndexI.firstStableIndex(new int[] {3, 2, 1}, 1));
    System.out.println(q3903ESmallestStableIndexI.firstStableIndex(new int[] {0}, 0));
  }
}
