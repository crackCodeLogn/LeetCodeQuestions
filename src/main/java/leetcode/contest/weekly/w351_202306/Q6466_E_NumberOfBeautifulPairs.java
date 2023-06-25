package leetcode.contest.weekly.w351_202306;

/**
 * @author Vivek
 * @since 2023-06-25
 */
public class Q6466_E_NumberOfBeautifulPairs {
    private static long getGcd(long a, long b) {
        if (a == 0) return b;
        return getGcd(b % a, a);
    }

    public static void main(String[] args) {
        Q6466_E_NumberOfBeautifulPairs q6466ENumberOfBeautifulPairs = new Q6466_E_NumberOfBeautifulPairs();
        System.out.println(q6466ENumberOfBeautifulPairs.countBeautifulPairs(new int[]{
                2, 5, 1, 4
        }));
        System.out.println(q6466ENumberOfBeautifulPairs.countBeautifulPairs(new int[]{
                11, 21, 12
        }));
    }

    public int countBeautifulPairs(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            int ch1 = (int) (String.valueOf(nums[i]).charAt(0)) - '0';
            //System.out.println(ch1);
            for (int j = i + 1; j < n; j++) {
                int ch2 = nums[j] % 10;
                if (getGcd(Math.min(ch1, ch2), Math.max(ch1, ch2)) == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
