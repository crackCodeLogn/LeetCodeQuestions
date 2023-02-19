package leetcode.contest.weekly.w332_202302;

import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2023-02-12
 */
public class Q2563_M_Count_the_Number_of_Fair_Pairs {

    private static <K> void augmentCount(TreeMap<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    private static <K> void decreaseCount(TreeMap<K, Integer> mapper, K key) {
        decreaseCount(mapper, key, 1);
    }

    private static <K> void decreaseCount(TreeMap<K, Integer> mapper, K key, int decCnt) {
        Integer val = mapper.get(key);
        if (val == decCnt) mapper.remove(key);
        else mapper.put(key, val - decCnt);
    }

    public static void main(String[] args) {
        Q2563_M_Count_the_Number_of_Fair_Pairs q2563MCounttheNumberofFairPairs = new Q2563_M_Count_the_Number_of_Fair_Pairs();
        System.out.println(q2563MCounttheNumberofFairPairs.countFairPairs(new int[]{
                0, 1, 7, 4, 4, 5
        }, 3, 6));
        System.out.println(q2563MCounttheNumberofFairPairs.countFairPairs(new int[]{
                1, 7, 9, 2, 5
        }, 11, 11));
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) augmentCount(map, nums[i]);
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            decreaseCount(map, x);
            for (int j = lower; j <= upper; j++) {
                if (map.containsKey(j - x)) cnt += map.get(j - x);
            }
        }
        return cnt;
    }
}
