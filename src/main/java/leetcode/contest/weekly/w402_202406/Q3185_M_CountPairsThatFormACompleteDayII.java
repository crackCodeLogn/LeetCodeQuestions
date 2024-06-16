package leetcode.contest.weekly.w402_202406;

/**
 * @author Vivek
 * @since 2024-06-16
 */
public class Q3185_M_CountPairsThatFormACompleteDayII {

    public static void main(String[] args) {
        Q3185_M_CountPairsThatFormACompleteDayII q3185MCountPairsThatFormACompleteDayII = new Q3185_M_CountPairsThatFormACompleteDayII();
        System.out.println(q3185MCountPairsThatFormACompleteDayII.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        System.out.println(q3185MCountPairsThatFormACompleteDayII.countCompleteDayPairs(new int[]{72, 48, 24, 3}));
    }

    public long countCompleteDayPairs(int[] hours) {
        long[] data = new long[24];
        long cnt = 0;
        for (int hour : hours) data[hour % 24]++;
        for (int hour : hours) {
            int k = hour % 24;
            data[k]--;
            cnt += data[k == 0 ? 0 : 24 - k];
        }
        return cnt;
    }
}
