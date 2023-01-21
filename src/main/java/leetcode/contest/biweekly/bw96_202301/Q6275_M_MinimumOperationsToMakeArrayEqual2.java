package leetcode.contest.biweekly.bw96_202301;

/**
 * @author Vivek
 * @since 2023-01-21
 */
public class Q6275_M_MinimumOperationsToMakeArrayEqual2 {

    public static void main(String[] args) {
        Q6275_M_MinimumOperationsToMakeArrayEqual2 q6275MMinimumOperationsToMakeArrayEqual2 = new Q6275_M_MinimumOperationsToMakeArrayEqual2();
        System.out.println(q6275MMinimumOperationsToMakeArrayEqual2.minOperations(new int[]{
                4, 3, 1, 4
        }, new int[]{
                1, 3, 7, 1
        }, 3));
        System.out.println(q6275MMinimumOperationsToMakeArrayEqual2.minOperations(new int[]{
                3, 8, 5, 2
        }, new int[]{
                2, 4, 1, 6
        }, 1));

        System.out.println(q6275MMinimumOperationsToMakeArrayEqual2.minOperations(new int[]{
                13, 6, 10, 16
        }, new int[]{
                1, 16, 12, 16
        }, 2));
        System.out.println(q6275MMinimumOperationsToMakeArrayEqual2.minOperations(new int[]{
                15, 31, 20, 3, 28, 19
        }, new int[]{
                36, 31, 14, 0, 34, 1
        }, 3));
        System.out.println(q6275MMinimumOperationsToMakeArrayEqual2.minOperations(new int[]{
                10, 5, 15, 20
        }, new int[]{
                20, 10, 15, 5
        }, 0));
        System.out.println(q6275MMinimumOperationsToMakeArrayEqual2.minOperations(new int[]{
                5, 5, 5, 5
        }, new int[]{
                5, 5, 5, 5
        }, 2));
    }

    public long minOperations(int[] nums1, int[] nums2, int k) {
        long sum1 = 0, sum2 = 0;
        boolean allSame = true;
        for (int i = 0; i < nums1.length; i++) sum1 += nums1[i];
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            if (nums1[i] != nums2[i]) allSame = false;
        }
        if (allSame) return 0;
        if (sum1 != sum2 || k == 0) return -1;

        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = nums2[i] - nums1[i];
            if (diff % k != 0) return -1;
            if (diff > 0) sum += diff / k;
        }
        return sum;
    }
}
