package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q1460_E_MakeTwoArraysEqualByReversingSubarrays {

    public boolean canBeEqual(int[] target, int[] arr) { // 1ms
        int[] data = new int[1001];
        for (int x : arr) data[x]++;
        for (int x : target) {
            if (data[x] <= 0) return false;
            data[x]--;
        }
        for (int i = 1; i <= 1000; i++) if (data[i] > 0) return false;
        return true;
    }

    public boolean canBeEqual2(int[] target, int[] arr) { // 6ms
        Map<Integer, Integer> data = new HashMap<>();
        for (int x : arr)
            if (data.containsKey(x)) data.put(x, data.get(x) + 1);
            else data.put(x, 1);
        for (int x : target) {
            if (data.containsKey(x)) {
                if (data.get(x) == 1) data.remove(x);
                else data.put(x, data.get(x) - 1);
            } else return false;
        }
        return data.isEmpty();
    }
}
