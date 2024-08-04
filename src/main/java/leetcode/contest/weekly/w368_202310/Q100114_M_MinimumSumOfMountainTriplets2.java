package leetcode.contest.weekly.w368_202310;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2023-10-22
 */
public class Q100114_M_MinimumSumOfMountainTriplets2 {
    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    private static <K> void decreaseCount(Map<K, Integer> mapper, K key) {
        decreaseCount(mapper, key, 1);
    }

    private static <K> void decreaseCount(Map<K, Integer> mapper, K key, int decCnt) {
        Integer val = mapper.get(key);
        if (val == decCnt) mapper.remove(key);
        else mapper.put(key, val - decCnt);
    }

    public static void main(String[] args) {
        Q100114_M_MinimumSumOfMountainTriplets2 minimumSumOfMountainTriplets2 = new Q100114_M_MinimumSumOfMountainTriplets2();
        System.out.println(minimumSumOfMountainTriplets2.minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(minimumSumOfMountainTriplets2.minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(minimumSumOfMountainTriplets2.minimumSum(new int[]{6, 5, 4, 3, 4, 5}));
    }

    public int minimumSum2(int[] nums) {
        int sum = Integer.MAX_VALUE, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) augmentCount(map, nums[i]);
        int lastJ = -1;

        for (int j = n - 1; j >= 0; j--) {
            if (lastJ != -1) decreaseCount(map, nums[lastJ]);
            lastJ = j;
            TreeMap<Integer, Integer> map2 = new TreeMap<>(map);
            decreaseCount(map2, nums[j]);
            for (int i = 0; i < j; i++) {
                decreaseCount(map2, nums[i]);
                int find = Math.max(nums[i], nums[j]) + 1;
                Integer key = map2.ceilingKey(find);
                if (key != null) {
                    sum = Math.min(sum, nums[i] + nums[j] + key);
                }
            }

        }


        /*for (int i = 0, j=n-1; i < j; ) {



            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] > nums[k]) {
                        sum = Math.min(sum, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }*/
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }

    public int minimumSum(int[] nums) {
        int[] min = new int[nums.length];
        int[] min2 = new int[nums.length];
        min[0] = -1;
        min2[min2.length - 1] = -1;
        int m = nums[0], n = nums.length;
        min[1] = m;
        for (int i = 2; i < nums.length; i++) {
            m = Math.min(m, nums[i - 1]);
            min[i] = m;
        }
        m = nums[n - 1];
        min2[n - 2] = m;
        for (int i = n - 3; i >= 0; i--) {
            m = Math.min(m, nums[i + 1]);
            min2[i] = m;
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min[i] == -1 || min2[i] == -1) continue;
            if (nums[i] > min[i] && nums[i] > min2[i]) sum = Math.min(sum, nums[i] + min[i] + min2[i]);
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}
