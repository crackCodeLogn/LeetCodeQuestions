package leetcode.contest.weekly.w391_202403;

/**
 * @author Vivek
 * @since 2024-03-31
 */
public class Q3101_M_CountAlternatingSubarrays {

    public static void main(String[] args) {
        Q3101_M_CountAlternatingSubarrays q3101MCountAlternatingSubarrays = new Q3101_M_CountAlternatingSubarrays();
        System.out.println(q3101MCountAlternatingSubarrays.countAlternatingSubarrays(new int[]{0, 1, 1, 1})); // 5
        System.out.println(q3101MCountAlternatingSubarrays.countAlternatingSubarrays(new int[]{1, 0, 1, 0})); // 10
        System.out.println(q3101MCountAlternatingSubarrays.countAlternatingSubarrays(new int[]{1, 0, 1, 1})); // ?
    }

    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long sum = n;
        int l = 0, r = 1;
        int last = nums[0];
        while (l < r && r < n) {
            while (r < n && nums[r] != last) {
                last = nums[r];
                r++;
            }
            if (r == n) {
                sum += calc(r - l - 1);
                break;
            }
            sum += calc(r - l - 1);
            l = r;
            r++;
        }

        return sum;
    }

    private long calc(long n) {
        return n * (n + 1) / 2;
    }

}
