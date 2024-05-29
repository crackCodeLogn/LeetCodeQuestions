package leetcode.contest.weekly.w399_202405;

/**
 * @author Vivek
 * @since 2024-05-26
 */
public class Q3162_E_FindTheNumberOfGoodPairsI {

    public static void main(String[] args) {
        Q3162_E_FindTheNumberOfGoodPairsI q = new Q3162_E_FindTheNumberOfGoodPairsI();
        System.out.println(q.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }
        return count;
    }
}
