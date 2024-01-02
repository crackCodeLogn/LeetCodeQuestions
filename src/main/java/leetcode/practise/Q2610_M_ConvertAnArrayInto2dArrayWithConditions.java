package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-01-02
 */
public class Q2610_M_ConvertAnArrayInto2dArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) { // 6ms
        int[] cnt = new int[201];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            max = Math.max(cnt[nums[i]], max);
        }
        List<List<Integer>> data = new ArrayList<>();
        while (max-- > 0) {
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < cnt.length; i++)
                if (cnt[i] > 0) {
                    cnt[i]--;
                    sub.add(i);
                }
            data.add(sub);
        }
        return data;
    }

    public List<List<Integer>> findMatrix3(int[] nums) { // 6ms
        Map<Integer, Integer> counterMap = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (counterMap.containsKey(nums[i])) {
                counterMap.put(nums[i], counterMap.get(nums[i]) + 1);
            } else {
                counterMap.put(nums[i], 1);
            }
            //max = Math.max(counterMap.get(nums[i]), max);
        }
        List<List<Integer>> data = new ArrayList<>(max);
        while (!counterMap.isEmpty()) {
            List<Integer> sub = new ArrayList<>();

            for (Integer key : new HashSet<>(counterMap.keySet())) {
                sub.add(key);
                int val = counterMap.get(key);
                if (val == 1) counterMap.remove(key);
                else counterMap.put(key, val - 1);
            }
            data.add(sub);
        }

        return data;
    }


    public List<List<Integer>> findMatrix2(int[] nums) { // 8ms
        int[] cnt = new int[201];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            max = Math.max(cnt[nums[i]], max);
        }
        List<List<Integer>> data = new ArrayList<>(max);
        while (max-- > 0) {
            List<Integer> sub = new ArrayList<>();
            boolean[] flag = new boolean[201];
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > 0 && !flag[i]) {
                    flag[i] = true;
                    cnt[i]--;
                    sub.add(i);
                }
            }
            data.add(sub);
        }

        return data;
    }
}
