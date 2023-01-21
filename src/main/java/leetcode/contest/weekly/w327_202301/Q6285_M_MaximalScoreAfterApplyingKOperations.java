package leetcode.contest.weekly.w327_202301;

import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2023-01-08
 */
public class Q6285_M_MaximalScoreAfterApplyingKOperations {

    private static <K> void augmentCount(TreeMap<Long, Integer> mapper, long key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    private static <K> void decreaseCount(TreeMap<K, Integer> mapper, K key, int decCnt) {
        Integer val = mapper.get(key);
        if (val == decCnt) mapper.remove(key);
        else mapper.put(key, val - decCnt);
    }

    public static void main(String[] args) {
        Q6285_M_MaximalScoreAfterApplyingKOperations q6285MMaximalScoreAfterApplyingKOperations = new Q6285_M_MaximalScoreAfterApplyingKOperations();
        System.out.println(q6285MMaximalScoreAfterApplyingKOperations.maxKelements(new int[]{
                10, 10, 10, 10, 10
        }, 5));
    }

    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            augmentCount(map, nums[i]);
        }
        while (k-- > 0) {
            long key = map.lastKey();
            sum += key;
            long val = (long) Math.ceil(key / 3.0);
            augmentCount(map, val);
            decreaseCount(map, key, 1);
        }
        return sum;
    }
}
