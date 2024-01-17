package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-01-17
 */
public class Q1207_E_UniqueNumberOfOccurrences {

    private static final int[] data = new int[2001];
    private static final int[] count = new int[1001];
    private static final Map<Integer, Integer> map = new HashMap<>();

    public boolean uniqueOccurrences(int[] arr) {
        map.clear();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }
        Set<Integer> d2 = new HashSet<>();
        for (Integer val : map.values()) {
            if (d2.contains(val)) return false;
            d2.add(val);
        }
        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        Arrays.fill(data, 0);
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num < 0) num = Math.abs(num) + 1000;
            data[num]++;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                if (count[data[i]] > 0) return false;
                count[data[i]]++;
            }
        }
        return true;
    }
}
