package leetcode.contest.weekly.w399_202405;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-05-26
 */
public class Q3164_M_FindTheNumbersOfGoodPairsII {

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q3164_M_FindTheNumbersOfGoodPairsII q = new Q3164_M_FindTheNumbersOfGoodPairsII();
        System.out.println(q.numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(q.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
        System.out.println(q.numberOfPairs(new int[]{70, 70}, new int[]{6, 10}, 7)); // 2
        System.out.println(q.numberOfPairs(new int[]{2, 8, 17, 6}, new int[]{3, 1, 1, 8}, 2)); // 7
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long[] n2 = new long[nums2.length];
        int n = nums1.length, m = nums2.length;
        for (int i = 0; i < m; i++) n2[i] = nums2[i] * (long) k;
//        boolean[] marker = new boolean[1_000_000 + 1];
        Map<Long, Integer> marker = new HashMap<>();
        //for (int i = 0; i < n; i++) marker[nums1[i]] = true;
        long limit = -1;
        for (int i = 0; i < n; i++) {
            augmentCount(marker, (long) nums1[i]);
            limit = Math.max(limit, nums1[i]);
        }

        Map<Long, Long> countMap = new HashMap<>();
        long cnt = 0;

        for (int j = 0; j < m; j++) {
            if (countMap.containsKey(n2[j])) cnt += countMap.get(n2[j]);
            else {
                long c2 = 0;
                for (long v = n2[j]; v <= limit; v += n2[j])
                    if (marker.containsKey(v))
                        c2 += marker.get(v);
                countMap.put(n2[j], c2);
                cnt += c2;
            }
        }
        return cnt;
    }
}
