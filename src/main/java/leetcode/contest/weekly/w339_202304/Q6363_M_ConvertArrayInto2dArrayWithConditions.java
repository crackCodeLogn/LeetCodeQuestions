package leetcode.contest.weekly.w339_202304;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-04-02
 */
public class Q6363_M_ConvertArrayInto2dArrayWithConditions {

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q6363_M_ConvertArrayInto2dArrayWithConditions q6363MConvertArrayInto2DArrayWithConditions = new Q6363_M_ConvertArrayInto2dArrayWithConditions();
        System.out.println(q6363MConvertArrayInto2DArrayWithConditions.findMatrix(new int[]{
                1, 3, 4, 1, 2, 3, 1
        }));
        System.out.println(q6363MConvertArrayInto2DArrayWithConditions.findMatrix(new int[]{
                1, 2, 3, 4
        }));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Set<Integer>> intermed = new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) augmentCount(count, num);
        int maxV = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            Integer v = entry.getValue();
            if (v > maxV) maxV = v;
        }
        while (maxV-- > 0) intermed.add(new HashSet<>());
        count.forEach((k, v) -> {
            int i = 0;
            while (v-- > 0) intermed.get(i++).add(k);
        });
        intermed.forEach(set -> result.add(new ArrayList<>(set)));
        return result;
    }
}
