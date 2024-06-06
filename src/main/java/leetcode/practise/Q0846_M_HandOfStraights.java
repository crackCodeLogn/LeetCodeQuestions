package leetcode.practise;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2024-06-06
 */
public class Q0846_M_HandOfStraights {

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
        Q0846_M_HandOfStraights q0846MHandOfStraights = new Q0846_M_HandOfStraights();
        System.out.println(q0846MHandOfStraights.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3)); // true
        System.out.println(q0846MHandOfStraights.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4)); // true
        System.out.println(q0846MHandOfStraights.isNStraightHand(new int[]{8, 10, 12}, 3)); // false
    }

    public boolean isNStraightHand(int[] hand, int groupSize) { // 43ms
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) augmentCount(map, hand[i]);

        for (int i = 1; i <= hand.length / groupSize; i++) {
            Integer base = map.firstKey();
            decreaseCount(map, base);
            int n = groupSize - 1;
            base++;
            while (n-- > 0) {
                if (!map.containsKey(base)) return false;
                decreaseCount(map, base);
                base++;
            }
        }
        return true;
    }
}
