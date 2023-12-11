package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-12
 */
public class Q2960_E_CountTestedDevicesAfterTestOperations {

    public int countTestedDevices(int[] batteryPercentages) {
        int cnt = 0, n = batteryPercentages.length;
        for (int i = 0; i < n; i++) {
            batteryPercentages[i] -= cnt;
            if (batteryPercentages[i] > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
