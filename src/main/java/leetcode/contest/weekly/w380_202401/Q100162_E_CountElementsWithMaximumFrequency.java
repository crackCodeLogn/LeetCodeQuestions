package leetcode.contest.weekly.w380_202401;

/**
 * @author Vivek
 * @since 2024-01-14
 */
public class Q100162_E_CountElementsWithMaximumFrequency {

    public static void main(String[] args) {
        Q100162_E_CountElementsWithMaximumFrequency q100162ECountElementsWithMaximumFrequency = new Q100162_E_CountElementsWithMaximumFrequency();
        System.out.println(q100162ECountElementsWithMaximumFrequency.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }

    public int maxFrequencyElements(int[] nums) {
        int[] data = new int[101];
        for (int v : nums) data[v]++;
        int max = 0, cnt = 0;
        for (int v : data) if (v > max) max = v;
        for (int v : data) if (v == max) cnt++;
        return cnt * max;
    }
}
