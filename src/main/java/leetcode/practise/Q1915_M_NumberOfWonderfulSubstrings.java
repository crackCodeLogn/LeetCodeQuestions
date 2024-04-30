package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

public class Q1915_M_NumberOfWonderfulSubstrings {
    private static final Map<Character, Integer> CHAR_BITMASK = new HashMap<>();

    private static long nC2(long n) {
        return n * (n - 1) / 2;
    }

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q1915_M_NumberOfWonderfulSubstrings q1915MNumberOfWonderfulSubstrings = new Q1915_M_NumberOfWonderfulSubstrings();
//        System.out.println(q1915MNumberOfWonderfulSubstrings.wonderfulSubstrings("aba")); // 4
        System.out.println(q1915MNumberOfWonderfulSubstrings.wonderfulSubstrings("aabb")); // 9
//        System.out.println(q1915MNumberOfWonderfulSubstrings.wonderfulSubstrings("he")); // 2
//        System.out.println(q1915MNumberOfWonderfulSubstrings.wonderfulSubstrings("aabbcc")); // 18
    }

    public long wonderfulSubstrings(String word) {
        if (CHAR_BITMASK.isEmpty()) for (char ch = 'a'; ch <= 'z'; ch++) CHAR_BITMASK.put(ch, 1 << (ch - 'a'));

        long res = 0;
        int prev = 0;
        int[] cnt = new int[1024];
        cnt[0] = 1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            prev ^= CHAR_BITMASK.get(ch);
            res += cnt[prev];
            for (char c = 'a'; c <= 'j'; c++)
                res += cnt[prev ^ CHAR_BITMASK.get(c)];
            cnt[prev]++;
        }
        return res;
    }

    public long wonderfulSubstrings2(String word) { // WA
        if (CHAR_BITMASK.isEmpty()) for (char ch = 'a'; ch <= 'z'; ch++) CHAR_BITMASK.put(ch, 1 << (ch - 'a'));

        long cnt = word.length();
        long prev = 0;
        Map<Long, Integer> counterMap = new HashMap<>();
        Map<Integer, Long> buffMap = new HashMap<>();
        buffMap.put(1, 1L);
        buffMap.put(2, 3L);
        int lastBufKey = 2;
//        counterMap.put(0L, 1);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            prev ^= CHAR_BITMASK.get(ch);
            augmentCount(counterMap, prev);
            if (prev > 0 && CHAR_BITMASK.containsValue(prev)) cnt++;
        }
        cnt--;
        for (Integer val : counterMap.values())
            if (val > 1) {
                cnt++;
                for (int k = 2; k <= val; k++) {
                    if (!buffMap.containsValue(k))
                        buffMap.put(k, buffMap.get(k - 1) + 2);
                    cnt += buffMap.get(k);
                }
            }

        return cnt;
    }
}
