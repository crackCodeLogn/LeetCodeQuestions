package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-05-10
 */
public class Q2918_M_MinimumEqualSumOfTwoArraysAfterReplacingZeros {

  public static void main(String[] args) {
    Q2918_M_MinimumEqualSumOfTwoArraysAfterReplacingZeros
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros =
            new Q2918_M_MinimumEqualSumOfTwoArraysAfterReplacingZeros();

    System.out.println(
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros.minSum(
            new int[] {0, 17, 20, 17, 5, 0, 14, 19, 7, 8, 16, 18, 6},
            new int[] {21, 1, 27, 19, 2, 2, 24, 21, 16, 1, 13, 27, 8, 5, 3, 11, 13, 7, 29, 7}));
    System.out.println(
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros.minSum(
            new int[] {4, 0, 0}, new int[] {5, 0}));
    System.out.println(
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros.minSum(
            new int[] {4, 0, 0}, new int[] {5}));
    System.out.println(
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros.minSum(
            new int[] {4, 0, 0}, new int[] {5, 0, 0}));
    System.out.println(
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros.minSum(
            new int[] {3, 2, 0, 1, 0}, new int[] {6, 5, 0}));
    System.out.println(
        q2918MMinimumEqualSumOfTwoArraysAfterReplacingZeros.minSum(
            new int[] {2, 0, 2, 0}, new int[] {1, 4}));
  }

  public long minSum(int[] nums1, int[] nums2) { // 3ms, beats 88.73%
    int z1 = 0, z2 = 0;
    long sum1 = 0, sum2 = 0;
    for (int i = 0; i < nums1.length; i++) {
      if (nums1[i] == 0) z1++;
      sum1 += nums1[i];
    }
    for (int i = 0; i < nums2.length; i++) {
      if (nums2[i] == 0) z2++;
      sum2 += nums2[i];
    }
    if (z1 == 0 && z2 == 0) return sum1 == sum2 ? sum1 : -1;
    else if (z1 > 0 && z2 > 0) {
      // handle
      return Math.max(sum1 + z1, sum2 + z2);
    } else { // either is 0
      if (z1 == 0) {
        if (sum2 + z2 > sum1) return -1;
        else return sum1;
      } else {
        if (sum1 + z1 > sum2) return -1;
        else return sum2;
      }
    }
  }
}
