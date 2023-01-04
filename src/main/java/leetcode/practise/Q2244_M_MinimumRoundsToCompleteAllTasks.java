package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-01-05
 */
public class Q2244_M_MinimumRoundsToCompleteAllTasks {

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q2244_M_MinimumRoundsToCompleteAllTasks q2244MMinimumRoundsToCompleteAllTasks = new Q2244_M_MinimumRoundsToCompleteAllTasks();
        System.out.println(q2244MMinimumRoundsToCompleteAllTasks.minimumRounds(new int[]{
                2, 2, 3, 3, 2, 4, 4, 4, 4, 4
        }));
        System.out.println(q2244MMinimumRoundsToCompleteAllTasks.minimumRounds(new int[]{
                2, 3, 3
        }));
    }

    public int minimumRounds(int[] tasks) {
        int count = 0;
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) augmentCount(data, tasks[i]);

        for (Integer values : data.values()) {
            if (values == 1) return -1;
            if (values <= 3) count++;
            else if (values <= 6) count += 2;
            else {
                count += 2;
                values -= 4;
                count += values / 3;
            }
        }
        return count;
    }
}