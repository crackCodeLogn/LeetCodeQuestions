package leetcode.contest.weekly.w395_202404;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-04-28
 */
public class Q3132_M_FindTheIntegerAddedToArrayII {

    public static void main(String[] args) {
        Q3132_M_FindTheIntegerAddedToArrayII q3132MFindTheIntegerAddedToArrayII = new Q3132_M_FindTheIntegerAddedToArrayII();
        System.out.println(q3132MFindTheIntegerAddedToArrayII.minimumAddedInteger(new int[]{4, 20, 16, 12, 8}, new int[]{14, 18, 10})); // -2
        System.out.println(q3132MFindTheIntegerAddedToArrayII.minimumAddedInteger(new int[]{3, 5, 5, 3}, new int[]{7, 7})); // 2
        System.out.println(q3132MFindTheIntegerAddedToArrayII.minimumAddedInteger(new int[]{7, 9, 1, 4}, new int[]{0, 8})); // -1
        System.out.println(q3132MFindTheIntegerAddedToArrayII.minimumAddedInteger(new int[]{4, 7, 5}, new int[]{5})); // -2
        System.out.println(q3132MFindTheIntegerAddedToArrayII.minimumAddedInteger(new int[]{6, 3, 6, 7}, new int[]{6, 2})); // -1
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] delta = new int[nums2.length - 1];
        for (int i = 1; i < nums2.length; i++) delta[i - 1] = nums2[i] - nums2[i - 1];

        int v = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                v = Math.min(v, compute(nums1, nums2, i, j, delta));
            }
        }
        return v;
    }

    private int compute(int[] nums1, int[] nums2, int i, int j, int[] delta) {
        int[] local = new int[nums2.length];
        int k = 0;
        for (int c = 0; c < nums1.length; c++) if (c != i && c != j) local[k++] = nums1[c];

        int[] delta1 = new int[nums2.length - 1];
        for (int c = 1; c < local.length; c++) {
            delta1[c - 1] = local[c] - local[c - 1];
            if (delta1[c - 1] != delta[c - 1]) return Integer.MAX_VALUE;
        }
        return nums2[0] - local[0];
    }
}
