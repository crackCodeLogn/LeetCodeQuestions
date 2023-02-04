package leetcode.contest.biweekly.bw97_202302;

/**
 * @author Vivek
 * @since 2023-02-04
 */
public class Q6304_M_MaximumNumberOfIntegersToChooseFromARangeI {

    public static void main(String[] args) {
        Q6304_M_MaximumNumberOfIntegersToChooseFromARangeI q6304MMaximumNumberOfIntegersToChooseFromARangeI = new Q6304_M_MaximumNumberOfIntegersToChooseFromARangeI();
        System.out.println(q6304MMaximumNumberOfIntegersToChooseFromARangeI.maxCount(new int[]{
                1, 6, 5
        }, 5, 6));
        System.out.println(q6304MMaximumNumberOfIntegersToChooseFromARangeI.maxCount(new int[]{
                11
        }, 7, 50));
        System.out.println(q6304MMaximumNumberOfIntegersToChooseFromARangeI.maxCount(new int[]{
                1, 2, 3, 4, 5, 6, 6, 7
        }, 8, 1));
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        long sum = 0;
        int cnt = 0, j = 0;
        boolean[] ban = new boolean[n + 1];
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] <= n)
                ban[banned[i]] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!ban[i]) {
                if (sum + i <= maxSum) {
                    sum += i;
                    cnt++;
                } else break;
            }
        }
        return cnt;
    }
}
