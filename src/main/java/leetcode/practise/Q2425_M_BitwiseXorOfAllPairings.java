package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-01-15
 */
public class Q2425_M_BitwiseXorOfAllPairings {

  public static void main(String[] args) {
    Q2425_M_BitwiseXorOfAllPairings q2425MBitwiseXorOfAllPairings =
        new Q2425_M_BitwiseXorOfAllPairings();
    System.out.println(
        q2425MBitwiseXorOfAllPairings.xorAllNums(new int[] {2, 1, 3}, new int[] {10, 2, 5, 0}));
    System.out.println(
        q2425MBitwiseXorOfAllPairings.xorAllNums(new int[] {1, 2}, new int[] {3, 4}));
  }

  public int xorAllNums(int[] nums1, int[] nums2) { // 1ms, beats 100%
    int result = 0;
    int n1 = nums1.length, n2 = nums2.length;
    int s1 = 0, s2 = 0;
    for (int i = 0; i < n1; i++) s1 ^= nums1[i];
    for (int i = 0; i < n2; i++) s2 ^= nums2[i];
    if (isOdd(n2)) result ^= s1;
    if (isOdd(n1)) result ^= s2;
    return result;
  }

  private boolean isOdd(int n) {
    return (n & 1) == 1;
  }
}
