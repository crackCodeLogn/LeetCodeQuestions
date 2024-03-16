package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-03-16
 */
public class Q0525_M_ContiguousArray {

    public static void main(String[] args) {
        Q0525_M_ContiguousArray q0525MContiguousArray = new Q0525_M_ContiguousArray();
        System.out.println(q0525MContiguousArray.findMaxLength(new int[]{0, 1})); // 2
        System.out.println(q0525MContiguousArray.findMaxLength(new int[]{0, 1, 0})); // 2
        System.out.println(q0525MContiguousArray.findMaxLength(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1})); // 6
    }

    public int findMaxLength(int[] nums) { // 23ms
        int sum = 0, max = 0;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) sum++;
            else sum--;
            if (sum == 0) {
                if (i + 1 > max) max = i + 1;
                continue;
            }
            if (map.containsKey(sum)) {
                int[] data = map.get(sum);
                data[1] = i;
                if (data[1] - data[0] > max) max = data[1] - data[0];
            } else {
                map.put(sum, new int[]{i, 0});
            }
        }
        return max;
    }

    public int findMaxLength2(int[] nums) { // 25ms
        int sum = 0;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) sum++;
            else sum--;
            if (sum == 0) {
                map.put(0, new int[]{0, i + 1});
                continue;
            }
            if (map.containsKey(sum)) {
                map.get(sum)[1] = i;
            } else {
                map.put(sum, new int[]{i, 0});
            }
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            int diff = map.get(key)[1] - map.get(key)[0];
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
}
