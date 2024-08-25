package leetcode.contest.weekly.w412_202408;

/**
 * @author Vivek
 * @since 2024-08-24
 */
public class Q3265_M_CountAlmostEqualPairsI {

    public static void main(String[] args) {
        Q3265_M_CountAlmostEqualPairsI q3265MCountAlmostEqualPairsI = new Q3265_M_CountAlmostEqualPairsI();
//        System.out.println(q2.countPairs(new int[]{3, 12, 30, 17, 21})); // 2
//        System.out.println(q2.countPairs(new int[]{1, 1, 1, 1, 1})); // 10
        System.out.println(q3265MCountAlmostEqualPairsI.countPairs(new int[]{123, 321})); // 1
        System.out.println(q3265MCountAlmostEqualPairsI.countPairs(new int[]{123, 231})); // 0
    }

    public int countPairs(int[] nums) {
        int n = nums.length, cnt = 0;
        int[][] dp = new int[n][10];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 0) {
                dp[i][num % 10]++;
                num /= 10;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] c1 = dp[i], c2 = dp[j];
                int delta = compute(c1, c2);
                if (delta == 0) {
                    // check further for equivalence
                    int n1 = nums[i], n2 = nums[j];
                    while (n1 > 0 && n2 > 0 && delta <= 2) {
                        if (n1 % 10 != n2 % 10) delta++;
                        n1 /= 10;
                        n2 /= 10;
                    }
                    if (delta > 2) continue;
                    while (n1 > 0 && delta <= 2) {
                        if (n1 % 10 != 0) delta++;
                        n1 /= 10;
                    }
                    if (delta > 2) continue;
                    while (n2 > 0 && delta <= 2) {
                        if (n2 % 10 != 0) delta++;
                        n2 /= 10;
                    }
                    if (delta > 2) continue;
                    if (delta == 2 || delta == 0) cnt++;
                }
            }
        }
        return cnt;
    }

    private int compute(int[] c1, int[] c2) {
        int delta = 0;
//        if (c1[0] > 0 || c2[0] > 0) return delta;
        for (int i = 1; i < c1.length; i++) delta += Math.abs(c2[i] - c1[i]);
        return delta;
    }
}
