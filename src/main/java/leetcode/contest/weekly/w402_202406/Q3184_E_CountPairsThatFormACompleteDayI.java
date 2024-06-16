package leetcode.contest.weekly.w402_202406;

/**
 * @author Vivek
 * @since 2024-06-16
 */
public class Q3184_E_CountPairsThatFormACompleteDayI {

    public static void main(String[] args) {
        Q3184_E_CountPairsThatFormACompleteDayI q3184ECountPairsThatFormACompleteDayI = new Q3184_E_CountPairsThatFormACompleteDayI();
        System.out.println(q3184ECountPairsThatFormACompleteDayI.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        System.out.println(q3184ECountPairsThatFormACompleteDayI.countCompleteDayPairs(new int[]{72, 48, 24, 3}));
    }

    public int countCompleteDayPairs(int[] hours) {
        int cnt = 0, n = hours.length;
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) if ((hours[i] + hours[j]) % 24 == 0) cnt++;
        return cnt;
    }
}
