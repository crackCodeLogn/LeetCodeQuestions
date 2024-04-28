package leetcode.contest.weekly.w395_202404;

/**
 * @author Vivek
 * @since 2024-04-28
 */
public class Q3131_E_FindTheIntegerAddedToArrayI {
    public int addedInteger(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums1.length; i++) sum1 += nums1[i];
        for (int i = 0; i < nums2.length; i++) sum2 += nums2[i];
        return (sum2 - sum1) / nums1.length;
    }
}
