package leetcode.contest.weekly.w402_202406;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2024-06-16
 */
public class Q3186_M_MaximumTotalDamageWithSpellCasting {
    private Map<Integer, Long> data;

    private static <K> void augmentCount(Map<K, Long> mapper, K key) {
        Long val = mapper.get(key);
        if (val == null) val = 1L;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q3186_M_MaximumTotalDamageWithSpellCasting q3186MMaximumTotalDamageWithSpellCasting = new Q3186_M_MaximumTotalDamageWithSpellCasting();
        System.out.println(q3186MMaximumTotalDamageWithSpellCasting.maximumTotalDamage(new int[]{1, 1, 3, 4}));
        System.out.println(q3186MMaximumTotalDamageWithSpellCasting.maximumTotalDamage(new int[]{7, 1, 6, 6}));
    }

    public long maximumTotalDamage(int[] power) {
        data = new HashMap<>();
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < power.length; i++) augmentCount(map, power[i]);

        int[] seq = new int[map.size()];
        int i = 0;
        for (Integer key : map.keySet()) seq[i++] = key;

        return compute(seq, map, 0);
    }

    private long compute(int[] seq, TreeMap<Integer, Long> map, int index) {
        if (index >= seq.length) return 0;
        if (data.containsKey(index)) return data.get(index);

        long v1 = seq[index] * map.get(seq[index]) + compute(seq, map, findNextIndex(seq, index));
        long v2 = compute(seq, map, index + 1);
        long v = Math.max(v2, v1);
        data.put(index, v);
        return v;
    }

    private int findNextIndex(int[] seq, int index) {
        int src = seq[index];
        while (index < seq.length && seq[index] <= src + 2) index++;
        return index;
    }
}
