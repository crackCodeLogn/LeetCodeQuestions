package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-12-12
 */
public class Q1287_E_ElementAppearingMoreThan25PercentSortedArray {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] mapper = new int[n];
        int k = 0, base = n / 4;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], k++);
            int v = map.get(arr[i]);
            mapper[v]++;
            if (mapper[v] > base) return arr[i];
        }
        return -1;
    }
}
