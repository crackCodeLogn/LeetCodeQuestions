package leetcode.contest.weekly.w382_202401;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-01-28
 */
public class Q100206_M_FindTheMaximumNumberOfElementsInSubset {

    private static final Map<Integer, Integer> map = new HashMap<>();

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q100206_M_FindTheMaximumNumberOfElementsInSubset q100206MFindTheMaximumNumberOfElementsInSubset = new Q100206_M_FindTheMaximumNumberOfElementsInSubset();
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{5, 4, 1, 2, 2})); // 3
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{1, 3, 2, 4})); // 1
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{2, 4, 4, 2})); // 3
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{1, 1})); // 1
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{1, 16, 49, 16, 121})); // 1
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{4, 36, 81, 16, 25})); // 1
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{14, 14, 196, 196, 38416, 38416})); // 5
        System.out.println(q100206MFindTheMaximumNumberOfElementsInSubset.maximumLength(new int[]{4, 4, 16, 16, 256, 256, 65536, 65536})); // 7
    }

    public int maximumLength(int[] nums) {
        map.clear();

        for (int i = 0; i < nums.length; i++) augmentCount(map, nums[i]);
        List<Integer> targets = new ArrayList<>(1000);
        for (Integer key : map.keySet()) if (map.get(key) > 1) targets.add(key);
        Collections.sort(targets);

        Set<Integer> visited = new HashSet<>();
        int max = -1;
        for (int i = 0; i < targets.size(); i++) {
            int x = targets.get(i);
            if (x == 1) {
                max = Math.max(max, getMaxOdd(map.get(x)));
                continue;
            }
            if (visited.contains(x)) continue;

            visited.add(x);
            int k = 2;
            int current = 2;
            boolean flag = true;
            for (; ; k *= 2) {
                int a = fastPower(x, k);
                if (x < 0) break; //overflow

                Integer val = map.get(a);
                if (val == null) {
                    flag = false;
                    break;
                } else if (val >= 2) {
                    current += 2;
                    visited.add(a);

                    int v = fastPower(x, k * 2);
                    if (map.get(v) == null) {
                        current--;
                        break;
                    }
                } else {
                    current++;
                    break;
                }
            }
            if (current == 2) current = 1; // force downgrade as found no superior seq
            if (flag) max = Math.max(max, current);
        }
        return max == -1 ? 1 : max;
    }

    private int getMaxOdd(int v) {
        if ((v & 1) == 1) return v;
        return v - 1;
    }

    private int fastPower(int a, int n) {
        int data = 1;
        while (n > 0) {
            int last_bit = (n & 1);
            if (last_bit > 0) data *= a;
            a *= a;
            n >>= 1;
        }
        return data;
    }
}
