package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-09-03
 */
public class Q3875_E_ConstructUniformParityArrayI {

  public boolean uniformArray2(int[] nums1) { // 01ms, beats 100%
    return true;
  }

  public boolean uniformArray(int[] nums1) { // 1ms, beats 25.52%
    int n = nums1.length, evens = 0, odds = 0;
    for (int i = 0; i < n; i++) {
      if (isOdd(nums1[i])) odds++;
      else evens++;
    }
    if (n == evens || n == odds) return true;

    // go for all odd if possible - always possible to have all odds it semes in this case;
    return true;
  }

  private boolean isOdd(int n) {
    return (n & 1) == 1;
  }

  public static void main(String[] args) {
    Q3875_E_ConstructUniformParityArrayI q3875EConstructUniformParityArrayI =
        new Q3875_E_ConstructUniformParityArrayI();
    System.out.println(q3875EConstructUniformParityArrayI.uniformArray(new int[] {2, 3}));
    System.out.println(q3875EConstructUniformParityArrayI.uniformArray(new int[] {4, 6}));
  }
}
