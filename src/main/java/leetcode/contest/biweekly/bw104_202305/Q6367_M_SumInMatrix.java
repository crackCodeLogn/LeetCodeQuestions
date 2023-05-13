package leetcode.contest.biweekly.bw104_202305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2023-05-13
 */
public class Q6367_M_SumInMatrix {

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

    public int matrixSum(int[][] nums) {
        List<List<Integer>> data = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) list.add(nums[i][j]);
            Collections.sort(list);
            data.add(list);
        }

        int sum = 0;
        for (int j = nums[0].length - 1; j >= 0; j--) {
            int max = -1;
            for (int i = 0; i < nums.length; i++) max = Math.max(data.get(i).get(j), max);
            sum += max;
        }
        return sum;
    }

    public int matrixSum_OriginalAc(int[][] nums) {
        List<TreeMap<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < nums[i].length; j++) {
                augmentCount(map, nums[i][j]);
            }
            list.add(map);
        }

        int sum = 0;
        while (!list.get(0).isEmpty()) {
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                int key = list.get(i).lastKey();
                decreaseCount(list.get(i), key);
                max = Math.max(max, key);
            }
            sum += max;
        }
        return sum;
    }

}
