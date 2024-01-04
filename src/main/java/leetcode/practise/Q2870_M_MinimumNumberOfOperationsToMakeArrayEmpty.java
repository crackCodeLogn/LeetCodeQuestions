package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-01-04
 */
public class Q2870_M_MinimumNumberOfOperationsToMakeArrayEmpty {

    private static final int[] data = new int[(int) (1e6 + 1)];

    public static void main(String[] args) {
        Q2870_M_MinimumNumberOfOperationsToMakeArrayEmpty q2870MMinimumNumberOfOperationsToMakeArrayEmpty = new Q2870_M_MinimumNumberOfOperationsToMakeArrayEmpty();
        System.out.println(q2870MMinimumNumberOfOperationsToMakeArrayEmpty.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4})); // 4
        System.out.println(q2870MMinimumNumberOfOperationsToMakeArrayEmpty.minOperations(new int[]{2, 1, 2, 2, 3, 3})); // -1
        System.out.println(q2870MMinimumNumberOfOperationsToMakeArrayEmpty.calcOptimalFactors(10)); // 4 and not 5
        System.out.println(q2870MMinimumNumberOfOperationsToMakeArrayEmpty.calcOptimalFactors(7)); // 2
    }

    private int calcOptimalFactors(int n) {
        if (n <= 1) return Integer.MAX_VALUE;
        if (n <= 3) return 1;
        if (data[n] > 0) return data[n];
        data[n] = Math.min(calcOptimalFactors(n - 2), calcOptimalFactors(n - 3)) + 1;
        return data[n];
    }

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        int cnt = 0;
        for (Integer val : map.values()) {
            if (val == 1) return -1;
            cnt += calcOptimalFactors(val);
        }
        return cnt;
    }
}
