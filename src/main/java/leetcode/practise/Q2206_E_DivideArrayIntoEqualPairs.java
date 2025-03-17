package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-03-16
 */
public class Q2206_E_DivideArrayIntoEqualPairs {

  public static void main(String[] args) {
    Q2206_E_DivideArrayIntoEqualPairs q2206EDivideArrayIntoEqualPairs =
        new Q2206_E_DivideArrayIntoEqualPairs();
    System.out.println(q2206EDivideArrayIntoEqualPairs.divideArray(new int[] {3, 2, 3, 2, 2, 2}));
    System.out.println(q2206EDivideArrayIntoEqualPairs.divideArray(new int[] {1, 2, 3, 4}));
    System.out.println(q2206EDivideArrayIntoEqualPairs.divideArray(new int[] {1, 2, 2, 3}));
    System.out.println(q2206EDivideArrayIntoEqualPairs.divideArray(new int[] {1, 2, 2, 1}));
  }

  public boolean divideArray(int[] nums) { // 1ms, beats 100%
    int[] cnt = new int[501];
    for (int num : nums) cnt[num]++;
    for (int num : cnt) if ((num & 1) != 0) return false;
    return true;
  }
}
