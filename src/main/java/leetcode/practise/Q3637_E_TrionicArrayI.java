package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-02-02
 */
public class Q3637_E_TrionicArrayI {
  public static void main(String[] args) {
    Q3637_E_TrionicArrayI q3637ETrionicArrayI = new Q3637_E_TrionicArrayI();
    System.out.println(q3637ETrionicArrayI.isTrionic(new int[] {1, 3, 5, 4, 2, 6}));
    System.out.println(q3637ETrionicArrayI.isTrionic(new int[] {2, 1, 3}));
  }

  public boolean isTrionic(int[] nums) {
    if (nums.length < 4) return false;
    int i;
    for (i = 0; i < nums.length - 2 && nums[i] < nums[i + 1]; i++)
      ;
    if (i == 0) return false;
    int j = i;
    for (; j < nums.length - 1 && nums[j] > nums[j + 1]; j++)
      ;
    if (i == j || j == nums.length - 1) return false;

    for (; j < nums.length - 1 && nums[j] < nums[j + 1]; j++)
      ;
    return j == nums.length - 1;
  }
}
